package concurrency;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 使用显式的 Lock 对象
 * 显式的锁和内置的锁对比：
 * Lock 对象必须显式地创建、锁定和释放；而内置的锁是隐式地创建，锁定和释放；
 * Lock 对象在任务抛出异常时，仍能够在 finally 语句中将锁释放，保证系统稳定性；
 * 而内置锁如果任务抛出异常，则没有机会去执行清理工作。
 * 内置锁不能尝试着获取锁，或者尝试着获取锁一段时间然后放弃它，而 Lock 对象可以。
 *
 * @author wangzhichao
 * @since 2020/3/9
 */
public class MutexEvenGenerator extends IntGenerator {
    private int currEvenValue = 0;
    private ReentrantLock lock = new ReentrantLock();

    @Override
    public int next() {
        lock.lock();
        try {
            ++currEvenValue;
            Thread.yield();
            ++currEvenValue;
            // 即便这里发生了异常，也能保证将锁在 finally 子句中释放
//            if (currEvenValue > 100000) {
//                throw new RuntimeException();
//            }
            return currEvenValue; // return 子句必须放在 try 子句中，以确保 unlock() 不会过早发生，从而将数据暴露给第二个任务
        } finally {
            System.out.println("lock.unlock()");
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        EvenChecker.test(new MutexEvenGenerator());
    }
}
