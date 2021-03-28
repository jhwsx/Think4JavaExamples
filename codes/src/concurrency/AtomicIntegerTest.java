package concurrency;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 使用 AtomicInteger 来重写 AtomicityTest
 * <p>
 * 可以看到在这里 AtomicInteger 替代了 synchronized 关键字的同步方法。
 *
 * @author wangzhichao
 * @since 2020/3/10
 */
public class AtomicIntegerTest implements Runnable {
    private AtomicInteger i = new AtomicInteger(0);

    public int getValue() {
        return i.get();
    }

    public void evenIncrement() {
        i.getAndAdd(2); // 就是这一句代码
    }

    @Override
    public void run() {
        while (true) {
            // 生成偶数
            evenIncrement();
        }
    }

    public static void main(String[] args) {
        // 开启一个 5s 的定时器，5s 后退出程序
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.err.println("Aborting");
                System.exit(0);
            }
        }, 5000);
        AtomicIntegerTest ait = new AtomicIntegerTest();
        ExecutorService exec = Executors.newCachedThreadPool();
        exec.execute(ait);
        exec.shutdown();

        // 主线程检查是不是有生成的奇数
        while (true) {
            int value = ait.getValue();
            System.out.println(value);
            while (value % 2 != 0) {
                System.out.println(value + " is an odd number");
                System.exit(0);
            }
        }
    }
}
