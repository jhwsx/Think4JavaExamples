package concurrency.ex08;

import java.util.concurrent.TimeUnit;

/**
 * @author wangzhichao
 * @since 2020/3/2
 */
public class LiftOff implements Runnable {
    protected int countDown = 10;
    private static int taskCount = 0;
    private final int id = taskCount++;

    public LiftOff() {}

    public LiftOff(int countDown) {
        this.countDown = countDown;
    }

    public String status() {
        return "#" + id + "(" +
                (countDown > 0 ? countDown : "LiftOff!") + "), ";
    }
    @Override
    public void run() {
        while (countDown-- > 0) {
//            try {
//                TimeUnit.SECONDS.sleep(1);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
            System.out.println(status());
            Thread.yield();
        }
    }
}
