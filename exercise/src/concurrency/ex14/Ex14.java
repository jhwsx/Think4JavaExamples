package concurrency.ex14;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Demonstrate that java.util.Timer scales to large numbers by
 * creating a program that generates many Timer objects that perform
 * some simple task when the timeout completes.
 *
 * @author wangzhichao
 * @since 2020/3/12
 */

public class Ex14 implements Runnable {
    private int count = 0;
    @Override
    public void run() {
        while (count < 4000) {
            count++;
            Timer timer = new Timer();
            timer.schedule(new TimerTask() {

                @Override
                public void run() {
                    System.out.println("TimerTask " + timer + " run.");
                }
            }, 5000);
        }
    }
    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        exec.execute(new Ex14());
        exec.shutdown();
    }


}
