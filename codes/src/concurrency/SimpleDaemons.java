package concurrency;

import java.util.concurrent.TimeUnit;

/**
 * 后台线程：当所有非后台线程都死亡时，程序就退出了，并杀死所有进程中的所有后台线程。
 * 只要有任何非后台线程存活，那么程序就不会终止。
 * @author wangzhichao
 * @since 2020/3/4
 */
public class SimpleDaemons implements Runnable {

    @Override
    public void run() {
        try {
            while (true) {
                TimeUnit.MILLISECONDS.sleep(100);
                System.out.println(Thread.currentThread() + " " + this);
            }
        } catch (InterruptedException e) {
            System.out.println("sleep() interrupted");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            Thread daemon = new Thread(new SimpleDaemons());
            // 在线程调用 start 方法之前，调用 setDaemon(), 才能把它设置为守护线程。
            daemon.setDaemon(true); // 假如不设置这句代码，那么后台的任务是循环，会一直打印。
            daemon.start();
        }
        System.out.println("All daemons started");
        // 改变这个值，体会一下：主线程结束后，可以看到后台线程的任务打印循环次数有所不同。
        TimeUnit.MILLISECONDS.sleep(90);
    }
}
