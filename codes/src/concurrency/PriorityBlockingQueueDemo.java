package concurrency;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * PriorityBlockingQueue 是一个基础的优先级队列，具有可阻塞的读取操作。
 *
 * @author wangzhichao
 * @since 2021/4/18
 */
class PrioritizedTask implements Runnable, Comparable<PrioritizedTask> {
    private final Random rand = new Random(47);
    private static int counter = 0;
    private final int id = counter++;
    private final int priority;
    protected static List<PrioritizedTask> sequence = new ArrayList<>();

    public PrioritizedTask(int priority) {
        this.priority = priority;
        sequence.add(this);
    }

    @Override
    public int compareTo(PrioritizedTask arg) {
        return priority < arg.priority ? 1 : (priority > arg.priority ? -1 : 0);
    }

    @Override
    public void run() {
        // 模拟任务执行的时间值。
        try {
            TimeUnit.MILLISECONDS.sleep(rand.nextInt(250));
        } catch (InterruptedException e) {
            // Acceptable way to exit
        }
        System.out.println(this);
    }

    @Override
    public String toString() {
        return String.format("[%1$-3d]", priority) + " Task " + id;
    }

    public String summary() {
        return "(" + id + ":" + priority + ")";
    }

    public static class EndSentinel extends PrioritizedTask {
        private final ExecutorService exec;

        public EndSentinel(ExecutorService exec) {
            super(-1); // -1 就是程序中最低的优先级。
            this.exec = exec;
        }

        @Override
        public void run() {
            // 打印任务创建序列的列表
            int count = 0;
            for (PrioritizedTask pt : sequence) {
                System.out.print(pt.summary());
                // 每 5 个换一行
                if (++count % 5 == 0) {
                    System.out.println();
                }
            }
            System.out.println();
            System.out.println(this + " Calling shutdownNow()");
            exec.shutdownNow();
        }
    }
}

// 生产者任务
class PrioritizedTaskProducer implements Runnable {
    private final Random rand = new Random(47);
    private Queue<Runnable> queue;
    private ExecutorService exec;

    public PrioritizedTaskProducer(Queue<Runnable> q, ExecutorService e) {
        this.queue = q;
        this.exec = e;
    }

    @Override
    public void run() {
        // 无界队列；不会阻塞
        // 使用随机的优先级来快速填充这个队列
        for (int i = 0; i < 20; i++) {
            queue.add(new PrioritizedTask(rand.nextInt(10)));
            Thread.yield();
        }
        // Trickle in highest-priority jobs:
        try {
            for (int i = 0; i < 10; i++) {
                TimeUnit.MILLISECONDS.sleep(250);
                queue.add(new PrioritizedTask(10));
            }
            // 添加 jobs，最低优先级的优先：
            for (int i = 0; i < 10; i++) {
                queue.add(new PrioritizedTask(i));
            }
            // 尾部哨兵，用于停止所有的任务
            queue.add(new PrioritizedTask.EndSentinel(exec));
        } catch (InterruptedException e) {
            // Acceptable way to exit
        }
        System.out.println("Finished PrioritizedTaskProducer");
    }
}

// 消费者任务
class PrioritizedTaskConsumer implements Runnable {
    private final PriorityBlockingQueue<Runnable> q;

    public PrioritizedTaskConsumer(PriorityBlockingQueue<Runnable> q) {
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
        System.out.println("Finished PrioritizedTaskConsumer");
    }
}

public class PriorityBlockingQueueDemo {
    public static void main(String[] args) throws Exception {
        ExecutorService exec = Executors.newCachedThreadPool();
        PriorityBlockingQueue<Runnable> queue = new PriorityBlockingQueue<>();
        exec.execute(new PrioritizedTaskProducer(queue, exec));
        exec.execute(new PrioritizedTaskConsumer(queue));
    }
}
