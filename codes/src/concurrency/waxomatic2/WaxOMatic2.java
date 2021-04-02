package concurrency.waxomatic2;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 在 lock.lock() 与 lock.unlock() 之间调用 Condition 对象的 await(), signal(), signalAll() 方法。
 *
 * @author wangzhichao
 * @since 2021/4/2
 */
class Car {
    private boolean waxOn = false;
    private Lock lock = new ReentrantLock();
    // Condition 对象用来管理任务之间的通信
    private Condition condition = lock.newCondition();

    public void waxed() {
        lock.lock();
        try {
            waxOn = true;
            condition.signalAll();
        } finally {
            lock.unlock();
        }
    }

    public void buffed() {
        lock.lock();
        try {
            waxOn = false;
            condition.signalAll();
        } finally {
            lock.unlock();
        }
    }

    public void waitForWaxing() throws InterruptedException {
        lock.lock();
        try {
            while (waxOn == false) {
                condition.await();
            }
        } finally {
            lock.unlock();
        }
    }

    public void waitForBuffing() throws InterruptedException {
        lock.lock();
        try {
            while (waxOn == true) {
                condition.await();
            }
        } finally {
            lock.unlock();
        }
    }
}

class WaxOn implements Runnable {
    private Car car;

    public WaxOn(Car car) {
        this.car = car;
    }

    @Override
    public void run() {
        try {
            while(!Thread.interrupted()) {
                // 涂蜡
                System.out.print("Wax On! ");
                TimeUnit.MILLISECONDS.sleep(200);
                car.waxed();
                car.waitForBuffing(); // 如果 waxOn 是 true，就在这里等待，挂起线程
            }
        } catch (InterruptedException e) {
            System.out.println("Exiting via interrupt");
        }
        System.out.println("Exiting Wax On task");
    }
}

// WaxOff 任务，对应于消费者任务
class WaxOff implements Runnable {

    private Car car;

    public WaxOff(Car car) {
        this.car = car;
    }

    @Override
    public void run() {
        try {
            while(!Thread.interrupted()) {
                car.waitForWaxing(); // 如果 waxOn 是 false，就在这里等待，挂起线程
                // 抛光，除去蜡
                System.out.print("Wax Off! ");
                TimeUnit.MILLISECONDS.sleep(200);
                car.buffed();
            }
        } catch (InterruptedException e) {
            System.out.println("Exiting via interrupt");
        }
        System.out.println("Exiting Wax Off task");
    }
}
public class WaxOMatic2 {
    public static void main(String[] args) throws InterruptedException {
        Car car = new Car();
        ExecutorService exec = Executors.newCachedThreadPool();
        exec.execute(new WaxOn(car));
        exec.execute(new WaxOff(car));
        TimeUnit.SECONDS.sleep(5);
        exec.shutdownNow(); // 给所有的任务发出中断信号
    }
}
