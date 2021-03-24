package concurrency;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 演示一个被 ReentrantLock 锁阻塞的任务
 *
 * @author wangzhichao
 * @since 2021/3/24
 */
class BlockedMutex {
    private Lock lock = new ReentrantLock();

    public BlockedMutex() {
        // 在构造中就立马获取锁
        lock.lock();
    }

    public void f() {
        try {
            lock.lockInterruptibly(); // 不可能获取到锁，所以会阻塞在这里，下面一行代码不会得到执行的。
            System.out.println("lock acquired in f()");
        } catch (InterruptedException e) {
            System.out.println("Interrupted from lock acquisition in f()");
        }
    }
}

class Block2 implements Runnable {
    BlockedMutex blocked = new BlockedMutex();

    @Override
    public void run() {
        System.out.println("Waiting for f() in BlockedMutex");
        blocked.f();
        System.out.println("Broken out of blocked call");
    }
}

public class Interrupting2 {
    public static void main(String[] args) throws Exception {
        Thread t = new Thread(new Block2());
        t.start();
        TimeUnit.SECONDS.sleep(1);
        System.out.println("Issuing t.interrupt()");
        t.interrupt();
    }
}

/*
打印结果：
 Waiting for f() in BlockedMutex
 Issuing t.interrupt()
 Interrupted from lock acquisition in f()
 Broken out of blocked call
 */
