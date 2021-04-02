package concurrency.ex26;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * 向 Restaurant.java 中添加一个 BusBoy 类。在上菜之后，WaitPerson 应该通知 BusBoy 清理。
 *
 * @author wangzhichao
 * @since 2021/3/31
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
    boolean clean = true;
    Meal m;
    public WaitPerson(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                synchronized (this) { // 这个锁是 WaitPerson 对象。
                    while (restaurant.meal == null) {
                        wait();
                    }
                }
                m = restaurant.meal;
                System.out.println("WaitPerson got " + restaurant.meal);
                synchronized (restaurant.chef) { // 这个锁是 Chef 对象。
                    restaurant.meal = null;
                    restaurant.chef.notifyAll();
                }
                synchronized (restaurant.busBoy) {
                    clean = false;
                    restaurant.busBoy.notifyAll();
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

    public Chef(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                synchronized (this) { // 这个锁是 Chef 对象。
                    while (restaurant.meal != null) {
                        wait();
                    }
                }
                if (++count == 10) {
                    System.out.println("Out of food, closing");
                    restaurant.exec.shutdownNow();
                }
                System.out.print("Order Up! ");
                synchronized (restaurant.waitPerson) { // 这个锁是 WaitPerson 对象。
                    restaurant.meal = new Meal(count);
                    restaurant.waitPerson.notifyAll();
                }
                TimeUnit.MILLISECONDS.sleep(100L);
            }
        } catch (InterruptedException e) {
            System.out.println("Chef interrupted");
        }
    }
}
// 餐馆工
class BusBoy implements Runnable {
    private final Restaurant restaurant;

    public BusBoy(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                synchronized (this) {
                    while (restaurant.waitPerson.clean) {
                        wait();
                    }
                }
                System.out.println("BusBoy cleaning up " + restaurant.waitPerson.m);
                restaurant.waitPerson.clean = true;
            }
        } catch (InterruptedException e) {
            System.out.println("BusBoy interrupted");
        }
    }
}


public class Restaurant {
    Meal meal;
    ExecutorService exec = Executors.newCachedThreadPool();
    final WaitPerson waitPerson = new WaitPerson(this);
    final Chef chef = new Chef(this);
    final BusBoy busBoy = new BusBoy(this);

    public Restaurant() {
        exec.execute(chef);
        exec.execute(waitPerson);
        exec.execute(busBoy);
    }
    public static void main(String[] args) {
        new Restaurant();
    }
}
