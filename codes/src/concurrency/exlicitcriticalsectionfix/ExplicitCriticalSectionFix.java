package concurrency.exlicitcriticalsectionfix;

import net.mindview.util.DaemonThreadFactory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

/**
 * https://blog.csdn.net/HoraceEz/article/details/107003148
 *
 * @author wangzhichao
 * @since 2021/3/17
 */
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

    public class PairNotEqualException extends RuntimeException {
        public PairNotEqualException() {
            super("Pair value not equal: " + Pair.this);
        }
    }

    public void checkState() {
        if (x != y) {
            throw new PairNotEqualException();
        }
    }
}


abstract class PairManager {
    protected AtomicInteger checkCounter = new AtomicInteger(0);
    final ReentrantLock lock = new ReentrantLock();

    protected Pair p = new Pair();

    List<Pair> storage = Collections.synchronizedList(new ArrayList<>());

    public Pair getPair() {
        lock.lock();
        try {
            return new Pair(p.getX(), p.getY());
        } finally {
            lock.unlock();
        }
    }

    protected void store(Pair p) {
        storage.add(p);
        try {
            TimeUnit.MILLISECONDS.sleep(50L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    protected abstract void increment();
}

class PairManager1 extends PairManager {

    @Override
    protected void increment() {
        lock.lock();
        try {
            p.incrementX();
            p.incrementY();
            store(getPair());
        } finally {
            lock.unlock();
        }
    }
}

class PairManager2 extends PairManager {

    @Override
    protected void increment() {
        Pair temp;
        lock.lock();
        try {
            p.incrementX();
            p.incrementY();
            temp = getPair();
        } finally {
            lock.unlock();
        }
        store(temp);
    }
}

// 生产者
class PairManipulator implements Runnable {

    private PairManager pm;

    public PairManipulator(PairManager pm) {
        this.pm = pm;
    }

    @Override
    public void run() {
        while (true) {
            pm.increment();
        }
    }

    @Override
    public String toString() {
        return "Pair: " + pm.getPair() + ", checkCounter = " + pm.checkCounter.get();
    }
}

class PairChecker implements Runnable {
    private PairManager pm;

    public PairChecker(PairManager pm) {
        this.pm = pm;
    }

    @Override
    public void run() {
        while (true) {
            pm.checkCounter.incrementAndGet();
            pm.getPair().checkState();
        }
    }
}

public class ExplicitCriticalSectionFix {
    public static void main(String[] args) {
        testApproaches(new PairManager1(), new PairManager2());
    }

    static void testApproaches(PairManager1 pm1, PairManager2 pm2) {
        // 生产者任务
        PairManipulator
                pairManipulator1 = new PairManipulator(pm1),
                pairManipulator2 = new PairManipulator(pm2);
        // 消费者任务
        PairChecker
                pairChecker1 = new PairChecker(pm1),
                pairChecker2 = new PairChecker(pm2);
        // 跑起来吧
        ExecutorService exec = Executors.newCachedThreadPool(new DaemonThreadFactory());
        exec.execute(pairManipulator1);
        exec.execute(pairManipulator2);
        exec.execute(pairChecker1);
        exec.execute(pairChecker2);

        try {
            TimeUnit.MILLISECONDS.sleep(500L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("pairManipulator1=" + pairManipulator1 + "\npairManipulator2=" + pairManipulator2);
        System.exit(0);
    }
}
