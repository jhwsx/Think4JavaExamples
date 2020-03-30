package concurrency;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 使用 Lock 对象来创建明显的临界区
 * 这里只是演示代码，跑起来会有问题。主要用来说明 Lock 对象也可以创建明显的临界区。
 * @author wangzhichao
 * @since 2020/3/13
 */
class ExplicitPairManager1 extends PairManager {
    private Lock lock = new ReentrantLock();
    @Override
    void increment() {
        lock.lock();
        try {
            pair.incrementX();
            pair.incrementY();
            store(getPair());
        } finally {
            lock.unlock();
        }
    }
}

class ExplicitPairManager2 extends PairManager {
    private Lock lock = new ReentrantLock();
    @Override
    void increment() {
        Pair temp;
        lock.lock();
        try {
            pair.incrementX();
            pair.incrementY();
            temp = getPair();
        } finally {
            lock.unlock();
        }
        store(temp);
    }
}
public class ExplicitCriticalSection {
    public static void main(String[] args) {
        ExplicitPairManager1 explicitPairManager1 = new ExplicitPairManager1();
        ExplicitPairManager2 explicitPairManager2 = new ExplicitPairManager2();

        CriticalSection.testApproaches(explicitPairManager1, explicitPairManager2);
    }
}
