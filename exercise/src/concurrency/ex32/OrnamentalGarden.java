package concurrency.ex32;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Use a CountDownLatch to solve the problem of correlating the
 * results from the Entrances in OrnamentalGarden.java. Remove
 * the unnecessary code from the new version of the example.
 *
 * @author wangzhichao
 * @since 2020/4/8
 */
// 用来跟踪花园参观者的主计数值
class Count {
    private Random random = new Random(47);
    private int count;

    // 同步方法，控制了对 count 域的访问
    public synchronized int increment() {
        int temp = count;
        if (random.nextBoolean()) { // 有一半的次数会发生 yield
            Thread.yield();
        }
        return (count = ++temp);
    }

    // 同步方法，控制了对 count 域的访问
    public synchronized int value() {
        return count;
    }
}

class Entrance implements Runnable {
    // 静态的 Count 对象
    private static Count count = new Count();
    // 静态的 Entrance 容器
    private static List<Entrance> entrances = new ArrayList<>();
    // 每个 Entrance 自己统计的数目，表示通过某个特定入口进入的参观者的数量
    private int number = 0;
    // Entrance 的 id 号码，用来区分 Entrance 的
    private final int id;
    private CountDownLatch doneSignal;
    private CountDownLatch stopSignal;
    // canceled 是静态的，并且还用 volatile 修饰保证可见性
    private static volatile boolean canceled = false;

    // 该方法对 canceled 进行的操作是原子操作
    public static void cancel() {
        canceled = true;
    }

    public Entrance(int id, CountDownLatch doneSignal, CountDownLatch stopSignal) {
        this.id = id;
        this.doneSignal = doneSignal;
        this.stopSignal = stopSignal;
        // 把这个任务保存在列表里面。可以避免对死亡的任务进行垃圾回收。
        entrances.add(this);
    }

    @Override
    public void run() {
        while (stopSignal.getCount() != 0) {
            // 这段代码是每个 Entrance 自己统计数目的
            synchronized (this) { // this 是谁？this 就是 Entrance 对象。可是这个同步没有什么作用啊。
                number++;
            }
            // 这句是 Count 对象来统计，这是总的
            System.out.println(this + " Total: " + count.increment()); // increment() 方法是同步方法
            try {
                TimeUnit.MILLISECONDS.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Stopping " + this);
        doneSignal.countDown();
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
    static final int SIZE = 5;
    public static void main(String[] args) throws InterruptedException {
        ExecutorService exec = Executors.newCachedThreadPool();
        CountDownLatch stopSignal = new CountDownLatch(1);
        CountDownLatch doneSignal = new CountDownLatch(SIZE);
        for (int i = 0; i < SIZE; i++) {
            exec.execute(new Entrance(i, doneSignal, stopSignal));
        }
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//        Entrance.cancel();
        stopSignal.countDown();
        doneSignal.await();
        exec.shutdown();
        // 在超时超过 250 ms 之后，终止任务
//        if (!exec.awaitTermination(250, TimeUnit.MILLISECONDS)) {
//            System.out.println("Some tasks were not terminated");
//        }
        System.out.println("Total: " + Entrance.getTotalCount());
        System.out.println("Sum of Entrances: " + Entrance.sumEntrances());
    }
}
