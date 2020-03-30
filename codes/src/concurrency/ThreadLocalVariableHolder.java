package concurrency;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * ThreadLocal 类可以根除线程对变量的共享，这样可以防止任务在共享资源上产生冲突。
 * 线程本地存储，可以为使用相同变量的每个不同的线程创建不同的存储。
 * ThreadLocal 就是创建和管理线程本地的存储。
 *
 * @author wangzhichao
 * @since 2020/3/13
 */
class Accessor implements Runnable {
    // id
    private int id;

    public Accessor(int id) {
        this.id = id;
    }

    @Override
    public void run() {
        // 循环 先判断线程是否中断
        while (!Thread.currentThread().isInterrupted()) {
            // 在循环内，递增 increment()
            ThreadLocalVariableHolder.increment();
            // 打印 this
            System.out.println(this);
            // Thread.yield()
            Thread.yield();
        }
    }

    // 重写 toString() 方法 id，还有 ThreadLocal 的值
    @Override
    public String toString() {
        return "#" + id + ", value = " + ThreadLocalVariableHolder.get();
    }
}

public class ThreadLocalVariableHolder {
    // 静态的 ThreadLocal，初始化一个值给他
    private static ThreadLocal<Integer> value = new ThreadLocal<Integer>() {
        private Random random = new Random(47);

        @Override
        protected Integer initialValue() {
            return random.nextInt(1000);
        }
    };

    // increment 方法
    public static void increment() {
        value.set(value.get() + 1);
    }

    // get 方法
    public static int get() {
        return value.get();
    }

    // main 方法
    public static void main(String[] args) throws InterruptedException {
        // 开启五个任务
        ExecutorService exec = Executors.newCachedThreadPool();
        for (int i = 0; i < 5; i++) {
            exec.execute(new Accessor(i));
        }
        // 3 秒后停止
        TimeUnit.SECONDS.sleep(3);
        exec.shutdownNow();
    }

}

/*
 打印结果（片段）：
#2, value = 128256
#4, value = 122125
#2, value = 128257
#4, value = 122126
#2, value = 128258
#4, value = 122127
#2, value = 128259
#1, value = 131608
#2, value = 128260
#1, value = 131609
#2, value = 128261
#0, value = 121661
#2, value = 128262
#3, value = 134524
 */
// 可以看到的是：
// 每个线程都是在自己之前的打印的基础上递增。
