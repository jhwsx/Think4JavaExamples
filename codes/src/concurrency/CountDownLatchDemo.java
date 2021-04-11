package concurrency;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * 演示 CountDownLatch 的使用
 *
 * @author wangzhichao
 * @since 2021/4/11
 */
// 执行部分任务
class TaskPortion implements Runnable {

    private static int counter = 0;
    private final int id = counter++;
    private static Random rand = new Random(47);
    private final CountDownLatch countDownLatch;

    TaskPortion(CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        try {
            doWork();
            countDownLatch.countDown(); // 这个方法不会阻塞
        } catch (InterruptedException e) {
        }
    }

    public void doWork() throws InterruptedException {
        TimeUnit.MILLISECONDS.sleep(rand.nextInt(2000));
        System.out.println(this + " completed");
    }

    @Override
    public String toString() {
        return String.format("%1$-3d", id);
    }
}

class WaitingTask implements Runnable {
    private static int counter = 0;
    private final int id = counter++;
    private final CountDownLatch countDownLatch;

    WaitingTask(CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        try {
            countDownLatch.await(); // 这个方法会阻塞
            System.out.println("Latch barrier passed for " + this);
        } catch (InterruptedException e) {
            System.out.println(this + " interrupted");
        }
    }

    @Override
    public String toString() {
        return String.format("WaitingTask %1$-3d", id); // $ 表示被格式化的参数索引，1 表示第一个被格式化的参数索引， - 表示左对齐，3 表示占三位
    }
}

public class CountDownLatchDemo {
    static final int SIZE = 100;

    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        CountDownLatch countDownLatch = new CountDownLatch(SIZE);
        // 开启 10 个等待任务
        for (int i = 0; i < 10; i++) {
            exec.execute(new WaitingTask(countDownLatch));
        }
        // 开启 100 个任务片段
        for (int i = 0; i < SIZE; i++) {
            exec.execute(new TaskPortion(countDownLatch));
        }
        System.out.println("Launched all tasks");
        exec.shutdown();
    }
}
