package concurrency;

import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * @author wangzhichao
 * @since 2020/3/31
 */
// 休眠 100 s 阻塞的任务
// 这是可中断的阻塞示例
class SleepBlocked implements Runnable {

    @Override
    public void run() {
        try {
            TimeUnit.SECONDS.sleep(100);
        } catch (InterruptedException e) {
            System.out.println("InterruptedException");
        }
        System.out.println("Exiting SleepBlocked.run()");
    }
}

// 读写文件阻塞的任务
// 这是不可中断的阻塞示例
class IOBlocked implements Runnable {
    private InputStream in;

    public IOBlocked(InputStream is) {
        this.in = is;
    }

    @Override
    public void run() {
        try {
            System.out.println("Waiting for read():");
            in.read(); // 这样会抛出 IOException 异常
        } catch (IOException e) {
            if (Thread.currentThread().isInterrupted()) {
                System.out.println("Interrupted from blocked I/O");
            } else {
                throw new RuntimeException(e);
            }
        }
        System.out.println("Exiting IOBlocked.run()");
    }
}

// 同步控制造成的阻塞任务
// 这是不可中断的阻塞示例
class SynchronizedBlocked implements Runnable {
    public synchronized void f() {
        while (true) { // 这里永远不会释放锁
            Thread.yield();
        }
    }

    public SynchronizedBlocked() {
        new Thread() {
            @Override
            public void run() {
                f(); // 这个线程获取了锁，注意：这必须是一个不同于执行 run 方法的线程
            }
        }.start();
    }

    @Override
    public void run() {
        System.out.println("Trying to call f()");
        f(); // 这里一直拿不到锁，死锁了。
        System.out.println("Exiting SynchronizedBlocked.run()");
    }
}

public class Interrupting {
    private static ExecutorService exec =
            Executors.newCachedThreadPool();

    static void test(Runnable r) throws InterruptedException {
        Future<?> f = exec.submit(r);
        TimeUnit.MILLISECONDS.sleep(100);
        System.out.println("Interrupting " + r.getClass().getSimpleName());
        f.cancel(true); // 如果在运行就中断
        System.out.println("Interrupt sent to " + r.getClass().getSimpleName());
    }

    public static void main(String[] args) throws Exception {
        test(new SleepBlocked());
        test(new IOBlocked(System.in));
        test(new SynchronizedBlocked());
        TimeUnit.SECONDS.sleep(3);
        System.out.println("Aboring with System.exit(0)");
        System.exit(0);
    }
}
