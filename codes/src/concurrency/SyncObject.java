package concurrency;

/**
 * 在其他对象上同步
 * <p>
 * 两个任务可以同时进入同一个对象，这是因为这个对象上的方法是在不同的锁上同步的。
 *
 * @author wangzhichao
 * @since 2020/3/13
 */
class DualSynch {
    private Object syncObject = new Object();

    // 锁是 this
    public synchronized void f() {
        for (int i = 0; i < 5; i++) {
            System.out.println("f()");
            Thread.yield();
        }
    }

    // 锁是 syncObject
    public void g() {
        synchronized (this) {
            for (int i = 0; i < 5; i++) {
                System.out.println("g()");
                Thread.yield();
            }
        }
    }
}

public class SyncObject {
    public static void main(String[] args) {
        final DualSynch ds = new DualSynch();
        new Thread() {
            @Override
            public void run() {
                ds.f();
            }
        }.start();
        ds.g();
    }
}

// 打印结果：
// g()
// f()
// g()
// f()
// g()
// g()
// f()
// g()
// f()
// f()

// 如果把 synchronized (syncObject) 换成 synchronized (this)，则打印
// g()
// g()
// g()
// g()
// g()
// f()
// f()
// f()
// f()
// f()
