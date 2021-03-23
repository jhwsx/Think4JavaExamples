package concurrency.ex18;

/**
 * 创建一个非任务的类，它有一个用较长的时间间隔调用 sleep() 的方法。创建一个任务，它将调用这个非任务类
 * 上的那个方法。在 main() 中，启动该任务，然后调用 interrupt() 来终止它。请确保这个任务被安全地关闭。
 *
 * @author wangzhichao
 * @since 2020/4/1
 */

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * Create a non-task class with a method that calls sleep() for a long
 * interval. Create a task that calls the method in the non-task class.
 * In main(), start the task, then call interrupt() to terminate it. Make
 * sure that the task shuts down safely.
 **/
class NonTask {
    public static void rest() {
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            System.out.println("Sleep interrupted");
        } finally {
            System.out.println("Good Bye");
        }
    }
}

class Worker implements Runnable {

    @Override
    public void run() {
        NonTask.rest();
    }
}

public class Ex18 {
    public static void main(String[] args) {
        System.out.println("Approach-1");
        ExecutorService exec = Executors.newCachedThreadPool();
        Future<?> future = exec.submit(new Worker());
        try {
            TimeUnit.MILLISECONDS.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        future.cancel(true);
        exec.shutdown();

        System.out.println("Approach-2");
        Thread thread = new Thread(new Worker());
        thread.start();
        thread.interrupt();

        System.out.println("Approach-3");
        ExecutorService exec3 = Executors.newCachedThreadPool();
        exec3.execute(new Worker());
        exec3.shutdownNow();
    }
}
