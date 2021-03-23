package concurrency;

import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * 中断方式：
 * 1，使用 ExecutorService 的 submit 方法来启动任务，会返回一个 Future<?> 对象，通过调用这个 Future<?>的cancel() 方法可以中断单个的线程；
 * 2，使用 ExecutorService 的 shutdownNow() 方法，会发送一个 interrupt() 调用给它启动的所有线程，也就是中断所有的线程。
 * 参考：https://blog.csdn.net/horero/article/details/77622951
 *
 * 什么是可以中断的？什么又是不可以中断的？
 * sleep() 上的等待是可以终端的，I/O 和在 synchronized 块上的等待是不可中断的
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
        while (true) { // 这里是个死循环，所以一旦拿到了锁，就永远不会释放锁
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
        f(); // 这里一直拿不到锁，阻塞在这里，等待锁被释放后再拿到锁（实际上，锁被另外一个线程持有了，永远不会被释放）。
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
//        exec.shutdownNow();
        TimeUnit.SECONDS.sleep(3);
        System.out.println("Aborting with System.exit(0)");
        System.exit(0);
    }
}
