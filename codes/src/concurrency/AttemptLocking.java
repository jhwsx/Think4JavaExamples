package concurrency;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Lock 尝试获取锁
 * ReentrantLock 允许尝试获取但最终未获取锁
 *
 * @author wangzhichao
 * @since 2020/3/9
 */
public class AttemptLocking {
    private ReentrantLock lock = new ReentrantLock();

    public void untimed() {
        // 仅在锁为空闲时才会获取锁
        boolean captured = lock.tryLock();
        try {
            System.out.println("tryLock(): captured=" + captured
                    + ", lock.getHoldCount()=" + lock.getHoldCount());
        } finally {
            if (captured) {
                // 释放锁
                lock.unlock();
            }
        }
    }

    public void timed() {
        boolean captured = false;
        try {
            // 如果锁在 2 秒的时间内空闲，并且当前线程未中断，则获取锁
            captured = lock.tryLock(2, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        try {
            System.out.println("tryLock(2, TimeUnit.SECONDS): captured=" + captured
                    + ", lock.getHoldCount()=" + lock.getHoldCount());
        } finally {
            if (captured) {
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) {
        final AttemptLocking al = new AttemptLocking();
        al.untimed(); // True -- lock is available
        al.timed(); // True -- lock is available
        // Create a separate task to grab the lock:
        new Thread() {
            {
                setDaemon(true);
            }

            @Override
            public void run() {
                al.lock.lock();
                System.out.println("acquired");
            }
        }.start();
        // Thread.yield(); // Give the 2nd task a chance
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        al.untimed(); // False -- lock grabbed by task.
        al.timed(); // False -- lock grabbed by task.
    }
}
/*
打印结果：
tryLock(): captured=true, lock.getHoldCount()=1
tryLock(2, TimeUnit.SECONDS): captured=true, lock.getHoldCount()=1
acquired
tryLock(): captured=false, lock.getHoldCount()=0
tryLock(2, TimeUnit.SECONDS): captured=false, lock.getHoldCount()=0
 */
