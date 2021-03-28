package concurrency.ex21;

/**
 * @author wangzhichao
 * @since 2021/3/29
 */

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Create two Runnables, one with a run() that starts and calls wait().
 * The second class could capture the reference of the first Runnable
 * object. Its run() should call notifyAll() for the first task after some
 * number of seconds have passed so that the first task can display a
 * message. Test your classes using an Executor.
 **/
class Runnable1 implements Runnable {
    private volatile boolean signal = false;

    @Override
    public synchronized void run() {
        System.out.println("Runnable1 run start");
        while (!signal) {
            try {
                System.out.println("Runnable1 wait() here.");
                wait(); // wait 会挂起线程，并且释放锁。
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            signal = true;
        }

        System.out.println("Runnable1 do some tasks here.");
    }
}

class Runnable2 implements Runnable {

    private Runnable1 runnable1;

    public Runnable2(Runnable1 runnable1) {
        this.runnable1 = runnable1;
    }

    @Override
    public void run() {
        System.out.println("Runnable2 run start");
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Runnable2 wait lock");
        synchronized (runnable1) {
            System.out.println("Runnable2 runnable1.notifyAll()");
            runnable1.notifyAll();
        }
    }
}

public class Ex21 {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService threadPool = Executors.newCachedThreadPool();
        Runnable1 runnable1 = new Runnable1();
        threadPool.execute(runnable1); // 让任务1先运行
        TimeUnit.MILLISECONDS.sleep(1000);
        threadPool.execute(new Runnable2(runnable1)); // 停一会儿再运行任务2
        threadPool.shutdown();
    }
}
