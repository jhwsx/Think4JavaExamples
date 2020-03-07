package concurrency;

import java.util.concurrent.TimeUnit;

/**
 * 后台线程在不执行 finally 子句的情况下就会终止其 run 方法。
 *
 * @author wangzhichao
 * @since 2020/3/5
 */
class ADaemon implements Runnable {

    @Override
    public void run() {
        try {
            System.out.println("Starting ADaemon");
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            System.out.println("Exiting via InterruptedException");
        } finally {
            System.out.println("This should always run?"); // No
        }
    }
}

public class DaemonsDontRunFinally {
    public static void main(String[] args) {
        Thread t = new Thread(new ADaemon());
        t.setDaemon(true);
        t.start();
    }
}
