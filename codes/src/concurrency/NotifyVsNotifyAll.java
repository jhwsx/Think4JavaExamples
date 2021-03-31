package concurrency;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * 演示当 notifyAll() 因某个特定锁而被调用时，只有等待这个锁的任务才会被唤醒
 *
 * 所有的任务一开始执行都会调用 wait() 方法，然后挂起线程，释放锁。
 *
 * Task.blocker.prod(); 或 Task.blocker.prodAll(); 唤醒的是在 Task.blocker 锁上等待的任务，而不会唤醒
 * Task2.blocker 锁上等待的任务。
 *
 * @author wangzhichao
 * @since 2021/3/29
 */
class Blocker {
    synchronized void waitingCall() {
        try {
//            for(;;) { // 在本例中，换成 for(;;)也可以
            while (!Thread.interrupted()) {
                System.out.print(Thread.currentThread() + " wait() ");
                wait();
                System.out.print(Thread.currentThread() + " ");
            }
        } catch (InterruptedException e) {
            // OK to exit this way
            System.out.println(e);
        }
    }

    synchronized void prod() {
        notify();
    }

    synchronized void prodAll() {
        notifyAll();
    }
}

class Task implements Runnable {
    // 注意这里是静态的变量，所以所有的 Task 对象只会有一份 blocker 对象。
    static Blocker blocker = new Blocker();
    @Override
    public void run() {
        blocker.waitingCall();
    }
}

class Task2 implements Runnable {

    // 一个单独的 Blocker 对象
    static Blocker blocker = new Blocker();
    @Override
    public void run() {
        blocker.waitingCall();
    }
}
public class NotifyVsNotifyAll {
    public static void main(String[] args) throws Exception {
        ExecutorService exec = Executors.newCachedThreadPool();
        for (int i = 0; i < 5; i++) {
            exec.execute(new Task());
        }
        exec.execute(new Task2());
        // Timer 用来间隔调用 notify() 和 notifyAll() 来唤醒等待的任务。
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            boolean prod = true;
            @Override
            public void run() {
                if (prod) {
                    System.out.print("\nnotify() ");
                    Task.blocker.prod();
                    prod = false;
                } else {
                    System.out.print("\nnotifyAll() ");
                    Task.blocker.prodAll();
                    prod = true;
                }
            }
        }, 400,400);
        TimeUnit.SECONDS.sleep(5);
        timer.cancel();
        System.out.println("\nTimer canceled");
        TimeUnit.MILLISECONDS.sleep(500);
        System.out.print("Task2.blocker.prodAll() ");
        Task2.blocker.prodAll();
        TimeUnit.MILLISECONDS.sleep(500);
        System.out.println("\nShutting down");
        exec.shutdownNow(); // Interrupt all tasks
    }
}
