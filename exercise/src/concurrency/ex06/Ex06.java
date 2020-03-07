package concurrency.ex06;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author wangzhichao
 * @since 2020/3/2
 */
class SleepingRunnable implements Runnable {

    @Override
    public void run() {
        try {
            int time = new Random().nextInt(10) + 1;
            TimeUnit.SECONDS.sleep(time);
            System.out.println("sleep: " + time + " s.");
        } catch (InterruptedException e) {
            System.out.println("Interrupted");
        }
    }
}
public class Ex06 {
    public static void main(String[] args) {
        ExecutorService service = Executors.newCachedThreadPool();
        for (int i = 0; i < 50; i++) {
            service.execute(new SleepingRunnable());
        }
        service.shutdown();
    }
}
