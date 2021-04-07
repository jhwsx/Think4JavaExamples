package concurrency.ex27;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 修改 Restaurant.java，使其使用显式的 Lock 和 Condition 对象。
 *
 * @author wangzhichao
 * @since 2021/4/7
 */
class Meal {
    private final int orderNum;

    public Meal(int orderNum) {
        this.orderNum = orderNum;
    }

    public String toString() {
        return "Meal " + orderNum;
    }
}

class WaitPerson implements Runnable {
    private Restaurant restaurant;
    Lock lock = new ReentrantLock();
    Condition condition = lock.newCondition();
    public WaitPerson(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
//                synchronized (this) { // 这个锁是 WaitPerson 对象。
//                    while (restaurant.meal == null) {
//                        wait();
//                    }
//                }
                lock.lock();
                try {
                    while(restaurant.meal == null) {
                        condition.await();
                    }
                } finally {
                    lock.unlock();
                }
                System.out.println("WaitPerson got " + restaurant.meal);
//                synchronized (restaurant.chef) { // 这个锁是 Chef 对象。
//                    restaurant.meal = null;
//                    restaurant.chef.notifyAll();
//                }
                restaurant.chef.lock.lock();
                try {
                    restaurant.meal = null;
                    restaurant.chef.condition.signalAll();
                } finally {
                    restaurant.chef.lock.unlock();
                }
            }
        } catch (InterruptedException e) {
            System.out.println("WaitPerson interrupted");
        }
    }
}

class Chef implements Runnable {
    private final Restaurant restaurant;
    private int count = 0;
    Lock lock = new ReentrantLock();
    Condition condition = lock.newCondition();
    public Chef(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
//                synchronized (this) { // 这个锁是 Chef 对象。
//                    while (restaurant.meal != null) {
//                        wait();
//                    }
//                }
                lock.lock();
                try {
                    while (restaurant.meal != null) {
                        condition.await();
                    }
                } finally {
                    lock.unlock();
                }
                if (++count == 10) {
                    System.out.println("Out of food, closing");
                    restaurant.exec.shutdownNow();
                }
                System.out.print("Order Up! ");
//                synchronized (restaurant.waitPerson) { // 这个锁是 WaitPerson 对象。
//                    restaurant.meal = new Meal(count);
//                    restaurant.waitPerson.notifyAll();
////                    restaurant.waitPerson.notify();
//                }
                restaurant.waitPerson.lock.lock();
                try {
                    restaurant.meal = new Meal(count);
                    restaurant.waitPerson.condition.signalAll();
                } finally {
                    restaurant.waitPerson.lock.unlock();
                }
                TimeUnit.MILLISECONDS.sleep(100L);
            }
        } catch (InterruptedException e) {
            System.out.println("Chef interrupted");
        }
    }
}

public class Restaurant {
    Meal meal;
    ExecutorService exec = Executors.newCachedThreadPool();
    final WaitPerson waitPerson = new WaitPerson(this);
    final Chef chef = new Chef(this);
    public Restaurant() {
        exec.execute(chef);
        exec.execute(waitPerson);
    }
    public static void main(String[] args) {
        new Restaurant();
    }
}

