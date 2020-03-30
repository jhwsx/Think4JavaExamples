package concurrency;

/**
 * 在其他对象上同步
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
        synchronized (syncObject) {
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
