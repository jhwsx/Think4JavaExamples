package concurrency;

import net.mindview.util.DaemonThreadFactory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 演示 synchronized 关键字对方法里的部分代码进行同步
 * 同步控制块，也就是同步方法内的部分代码，这段代码也叫临界区，而不是同步控制
 * 整个方法，这有利于性能提升。
 *
 * @author wangzhichao
 * @since 2020/3/12
 */
// Pair 类不是线程安全的
class Pair {
    private int x;
    private int y;

    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Pair() {
        this(0, 0);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void incrementX() {
        x++;
    }

    public void incrementY() {
        y++;
    }

    @Override
    public String toString() {
        return "x=" + x +
                ", y=" + y;
    }

    public class PairValueNotEqualException extends RuntimeException {
        public PairValueNotEqualException() {
            super("Pair value not equal: " + Pair.this);
        }
    }

    public void checkState() {
        if (x != y) {
            throw new PairValueNotEqualException();
        }
    }
}

// 模板方法设计模式, 这个类使得在线程环境中使用非线程安全的 Pair 类成为可能。
abstract class PairManager {
    AtomicInteger checkCounter = new AtomicInteger(0);
    List<Pair> storage = Collections.synchronizedList(new ArrayList<>());
    // PairManager 持有一个 Pair 对象并控制对它的一切访问。
    protected Pair pair = new Pair();

    // 这里是加了同步的方法
    public synchronized Pair getPair() {
        // 创建一个副本，以保证原来的 pair 成员变量是安全的
        return new Pair(pair.getX(), pair.getY());
    }

    // 把 Pair 对象存储到同步的集合中，这里模拟了耗时过程。
    public void store(Pair pair) {
        // 这个操作是线程安全的
        storage.add(pair);
        try {
            TimeUnit.MILLISECONDS.sleep(50);
        } catch (InterruptedException e) {
            System.err.println(e);
        }
    }
    // 将增长方法抽象出来，由子类来实现
    abstract void increment();
}

// 对 increment() 方法进行同步的实现
class PairManager1 extends PairManager {

    @Override
    synchronized void increment() {
        pair.incrementX();
        pair.incrementY();
        store(getPair());
    }
}

// 对 increment() 方法中的部分代码进行同步的实现
class PairManager2 extends PairManager {

    @Override
    void increment() {
        Pair temp;
        synchronized (this) {
            pair.incrementX();
            pair.incrementY();
                temp = getPair();
        }
        store(temp);
        // 为什么不这样写呢？ 这样就不会同步了，有可能存的并不是上面刚刚加好的。
//        store(getPair());
    }
}

// 这个可以理解为生产者
class PairManipulator implements Runnable {
    private PairManager pairManager;
    private Pair pair;

    public PairManipulator(PairManager pairManager) {
        this.pairManager = pairManager;
    }

    @Override
    public void run() {
        while (true) {
            pairManager.increment();
            pair = pairManager.getPair();
        }
    }

    @Override
    public String toString() {
        return "Pair: " + pair
                + ", checkCounter = " + pairManager.checkCounter.get();
    }
}

// 这个可以理解为消费者
class PairChecker implements Runnable {
    private PairManager pairManager;

    public PairChecker(PairManager pairManager) {
        this.pairManager = pairManager;
    }

    @Override
    public void run() {
        while (true) {
            // 每次检查成功后，都会加 1。
            pairManager.checkCounter.incrementAndGet();
            pairManager.getPair().checkState();
        }
    }

}

// 临界区类
public class CriticalSection {

    static void testApproaches(PairManager pm1, PairManager pm2) {
        ExecutorService exec = Executors.newCachedThreadPool(new DaemonThreadFactory());
        PairManipulator pairManipulator1 = new PairManipulator(pm1);
        PairManipulator pairManipulator2 = new PairManipulator(pm2);
        PairChecker pairChecker1 = new PairChecker(pm1);
        PairChecker pairChecker2 = new PairChecker(pm2);
        exec.execute(pairManipulator1);
        exec.execute(pairManipulator2);
        exec.execute(pairChecker1);
        exec.execute(pairChecker2);
        try {
            TimeUnit.MILLISECONDS.sleep(500);
        } catch (InterruptedException e) {
            System.out.println("Interrupted");
        }
        System.out.println("pairManipulator1 = " + pairManipulator1 + ", \npairManipulator2 = " + pairManipulator2);
        System.out.println("pm1 storage size:" + pm1.storage.size() + ",list = " + pm1.storage
                + ", \npm2 storage size:" + pm2.storage.size() + ",list = " + pm2.storage);
        System.exit(0);
    }

    public static void main(String[] args) {
        PairManager1 pairManager1 = new PairManager1();
        PairManager2 pairManager2 = new PairManager2();

        testApproaches(pairManager1, pairManager2);
    }
}
