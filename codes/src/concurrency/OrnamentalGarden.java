package concurrency;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * 统计参观花园的人数
 * 演示终止问题
 *
 * @author wangzhichao
 * @since 2020/3/30
 */
class Count {
    private Random random = new Random(47);
    private int count;

    public synchronized int increment() {
        int temp = count;
        if (random.nextBoolean()) {
            Thread.yield();
        }
        return (count = ++temp);
    }

    public synchronized int value() {
        return count;
    }
}

class Entrance implements Runnable {
    // 静态的 Count 对象
    private static Count count = new Count();
    // 静态的 Entrance 容器
    private static List<Entrance> entrances = new ArrayList<>();
    // 每个 Entrance 自己统计的数目
    private int number = 0;
    // Entrance 的 id 号码，用来区分 Entrance 的
    private final int id;
    // canceled 是静态的，并且还用 volatile 修饰保证可见性
    private static volatile boolean canceled = false;

    // 该方法对 canceled 进行的操作是原子操作
    public static void cancel() {
        canceled = true;
    }

    public Entrance(int id) {
        this.id = id;
        entrances.add(this);
    }

    @Override
    public void run() {
        while (!canceled) {
            // 这段代码是每个 Entrance 自己统计数目的
            synchronized (this) {
                number++;
            }
            // 这句是 Count 对象来统计，这是总的
            System.out.println(this + " Total: " + count.increment());
            try {
                TimeUnit.MILLISECONDS.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Stopping " + this);
    }

    public synchronized int getValue() {
        return number;
    }

    public String toString() {
        return "Entrance " + id + ": " + getValue();
    }

    public static int getTotalCount() {
        return count.value();
    }

    public static int sumEntrances() {
        int sum = 0;
        for (Entrance entrance : entrances) {
            sum += entrance.getValue();
        }
        return sum;
    }
}

public class OrnamentalGarden {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService exec = Executors.newCachedThreadPool();
        for (int i = 0; i < 5; i++) {
            exec.execute(new Entrance(i));
        }
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Entrance.cancel();
        exec.shutdown();
        // 在超时超过 250 ms 之后，终止任务
        if (!exec.awaitTermination(250, TimeUnit.MILLISECONDS)) {
            System.out.println("Some tasks were not terminated");
        }
        System.out.println("Total: " + Entrance.getTotalCount());
        System.out.println("Sum of Entrances: " + Entrance.sumEntrances());
    }
}
