package concurrency.waxomatic;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author wangzhichao
 * @since 2021/3/25
 */
// Car 实体类
class Car {
    private boolean waxOn = false;

    public synchronized void waxed() {
        waxOn = true;
        notifyAll();
    }

    public synchronized void buffed() {
        waxOn = false;
        notifyAll();
    }

    public synchronized void waitForWaxing() throws InterruptedException {
        while (waxOn == false) {
            wait();
        }
    }

    public synchronized void waitForBuffing() throws InterruptedException {
        while (waxOn == true) {
            wait();
        }
    }

}
// WaxOn 任务，对应于生产者任务
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
                // 擦拭，除去蜡
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

public class WaxOMatic {
    public static void main(String[] args) throws InterruptedException {
        Car car = new Car();
        ExecutorService exec = Executors.newCachedThreadPool();
        exec.execute(new WaxOn(car));
        exec.execute(new WaxOff(car));
        TimeUnit.SECONDS.sleep(5);
        exec.shutdownNow(); // 给所有的任务发出中断信号
    }
}
