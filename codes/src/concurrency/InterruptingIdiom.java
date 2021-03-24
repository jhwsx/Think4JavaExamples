package concurrency;

import java.util.concurrent.TimeUnit;

/**
 * Thread 类中的静态方法 interrupted()，检查中断状态，返回 true 表示 interrupt() 被调用过，
 * 并且这个方法还会清除中断状态。
 * public static boolean interrupted() {
 * return currentThread().isInterrupted(true);
 * }
 * Thread 类中的成员方法 isInterrupted()，检查中断状态，返回 true 或 false，不会对线程的
 * 中断状态有任何影响。
 * public boolean isInterrupted() {
 * return isInterrupted(false);
 * }
 *
 * @author wangzhichao
 * @since 2021/3/24
 */
class NeedsCleanup {
    private final int id;

    public NeedsCleanup(int indent) {
        id = indent;
        System.out.println("NeedsCleanup " + id);
    }

    public void cleanup() {
        System.out.println("Cleaning up " + id);
    }
}

class Block3 implements Runnable {
    private volatile double d = 0.0;

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                // point1
                NeedsCleanup n1 = new NeedsCleanup(1);
                // Start try-finally immediately after definition
                // of n1. to guarantee proper cleanup of n1:
                try {
                    System.out.println("Sleeping");
                    TimeUnit.SECONDS.sleep(1);
                    // point2
                    NeedsCleanup n2 = new NeedsCleanup(2);
                    // Guarantee proper cleanup of n2:
                    try {
                        System.out.println("Calculating");
                        // A time-consuming, non-blocking operation:
                        for (int i = 0; i < 2500000; i++) {
                            d = d + (Math.PI + Math.E) / d;
                        }
                        System.out.println("Finished time-consuming operation");
                    } finally {
                        n2.cleanup();
                    }
                } finally {
                    n1.cleanup();
                }
            }
            System.out.println("Exiting via while() test");
        } catch (InterruptedException e) {
            System.out.println("Exiting via InterruptedException");
        }

    }
}

// args: 1100 通过改变延迟时间，可以在不同地点退出 Block3.run() 方法。
public class InterruptingIdiom {
    public static void main(String[] args) throws InterruptedException {
        if (args.length != 1) {
            System.out.println("usage: java InterruptingIdiom delay-in-ms");
            System.exit(1);
        }
        Thread t = new Thread(new Block3());
        t.start();
        TimeUnit.MILLISECONDS.sleep(new Integer(args[0])); // 1100 ms 后发起中断
        t.interrupt(); // 发起中断：在 point2 之后，那么会因循环条件不满足而退出；在 point1 和 point2 之间，那么会因中断异常而退出。
    }
}
/*
设置参数为 1001 的打印结果：
NeedsCleanup 1
Sleeping
NeedsCleanup 2
Calculating
Finished time-consuming operation
Cleaning up 2
Cleaning up 1
Exiting via while() test // 这是 while 循环不满足条件而退出的
 */

/*
设置参数为 1100 的打印结果：
NeedsCleanup 1
Sleeping
NeedsCleanup 2
Calculating
Finished time-consuming operation
Cleaning up 2
Cleaning up 1
NeedsCleanup 1
Sleeping
Cleaning up 1
Exiting via InterruptedException // 这是 sleep() 方法被中断后而退出的
*/