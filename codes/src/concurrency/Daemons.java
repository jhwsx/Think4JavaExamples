package concurrency;

import java.util.concurrent.TimeUnit;

/**
 * isDaemon() 判断线程是否是后台线程；
 * 后台线程所创建的任何线程都会自动被设置为后台线程。
 *
 * @author wangzhichao
 * @since 2020/3/4
 */
class Daemon implements Runnable {
    private Thread[] tArray = new Thread[10];
    @Override
    public void run() {
        // 后台线程里，派生出许多线程，这些线程就自动被设置为后台线程了。
        for (int i = 0; i < tArray.length; i++) {
            tArray[i] = new Thread(new DaemonSpawn());
            tArray[i].start();
            System.out.println("DaemonSpawn " + i + " started.");
        }
        for (int i = 0; i < tArray.length; i++) {
            System.out.println("t[" + i + "].isDaemon() = " +
                    tArray[i].isDaemon() + ". ");
        }
        // 为什么调用 Thread.yield()??? 为了把控制权交给其他线程。
        while (true) {
            Thread.yield();
        }
    }
}

class DaemonSpawn implements Runnable {

    @Override
    public void run() {
        while (true) {
            Thread.yield();
        }
    }
}
public class Daemons {
    public static void main(String[] args) throws InterruptedException {
        Thread d = new Thread(new Daemon());
        d.setDaemon(true);
        d.start();
        System.out.println("d.isDaemon() = " + d.isDaemon() +", ");
        TimeUnit.SECONDS.sleep(1);
    }
}
