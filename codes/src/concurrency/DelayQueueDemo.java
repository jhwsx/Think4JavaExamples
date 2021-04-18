package concurrency;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;
import java.util.concurrent.TimeUnit.*;

import static java.util.concurrent.TimeUnit.MILLISECONDS;
import static java.util.concurrent.TimeUnit.NANOSECONDS;

/**
 * DelayQueue 是一个无界的 BlockingQueue，用于放置实现了 Delayed 接口的对象，其中的对象只能在到期时才能从队列中取走。
 * 这种队列是有序的，即队头对象的延迟到期的时间最长。如果没有任何延迟到期，那么就不会有任何头元素，并且 poll() 将返回 null
 * （正因为这样，不能将 null 放置到这种队列中）。
 * @author wangzhichao
 * @since 2021/4/13
 */
// DelayedTask 就是一个任务
class DelayedTask implements Runnable, Delayed {
    private static int counter = 0;
    private final int id = counter++;
    private final int delta;
    // 任务到期的时间点
    private final long trigger;
    // 保存被创建的任务，注意是静态的。
    protected static List<DelayedTask> sequence =
            new ArrayList<>();

    public DelayedTask(int delayInMilliseconds) {
        delta = delayInMilliseconds;
        // NANOSECONDS.convert(delta, MILLISECONDS) 把 delta 这个毫秒值，转为 NANOSECONDS
        trigger = System.nanoTime() + NANOSECONDS.convert(delta, MILLISECONDS);
        sequence.add(this);
    }

    // 获取延迟到期还有多长时间，或者延迟在多长时间之前已经到期。
    @Override
    public long getDelay(TimeUnit unit) {
        return unit.convert(trigger - System.nanoTime(), NANOSECONDS);
    }

    // Delayed 接口继承了 Comparable 接口，所以这里必须实现。
    @Override
    public int compareTo(Delayed arg) {
        DelayedTask that = (DelayedTask) arg;
        if (trigger < that.trigger) return -1;
        if (trigger > that.trigger) return 1;
        return 0;
    }

    @Override
    public void run() {
        System.out.print(this + " ");
    }

    @Override
    public String toString() {
        // 中括号里打出任务的延时时间毫秒值，id 就是标识任务的。
        return String.format("[%1$-4d]", delta) + " Task " + id;
    }

    public String summary() {
        return "(" + id + ":" + delta + ")";
    }

    // 尾部哨兵，用于关闭所有事物，具体做法是将其放置为队列的最后一个元素。
    public static class EndSentinel extends DelayedTask {
        private final ExecutorService exec;
        public EndSentinel(int delay, ExecutorService e) {
            super(delay);
            exec = e;
        }

        @Override
        public void run() {
            // 打印一些信息，并终结所有的任务。
            for (DelayedTask pt : sequence) {
                System.out.print(pt.summary() + " ");
            }
            System.out.println();
            System.out.println(this + " Calling shutdownNow()");
            exec.shutdownNow();
        }
    }
}
// 将最“紧急”的任务（到期时间最长的任务）从队列中取出，然后运行它。
class DelayedTaskConsumer implements Runnable {

    private final DelayQueue<DelayedTask> q;

    public DelayedTaskConsumer(DelayQueue<DelayedTask> q) {
        this.q = q;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                q.take().run();
            }
        } catch (InterruptedException e) {
            // Acceptable way to exit
        }
        System.out.println("Finished DelayTaskConsumer");
    }
}
public class DelayQueueDemo {
    public static void main(String[] args) {
        Random rand = new Random(/*47*/);
        ExecutorService exec = Executors.newCachedThreadPool();
        DelayQueue<DelayedTask> queue =
                new DelayQueue<>();
        // 填充有随机延时的任务
        for (int i = 0; i < 20; i++) {
            queue.put(new DelayedTask(rand.nextInt(5000)));
        }
        // 设置停止的点
        queue.add(new DelayedTask.EndSentinel(5000, exec));
        // 执行 DelayedTaskConsumer 任务
        exec.execute(new DelayedTaskConsumer(queue));
    }
}

// 打印结果：是按照实际发生的顺序执行的，而不是按照排序执行的。
