package concurrency.ex04;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author wangzhichao
 * @since 2020/3/2
 */
public class SingleThreadExecutor {
    public static void main(String[] args) {
        ExecutorService newSingleThreadExecutor = Executors.newSingleThreadExecutor();
        for (int i = 1; i < 8; i++) {
            newSingleThreadExecutor.execute(new FibonacciRunnable(i));
        }
        newSingleThreadExecutor.shutdown();
    }
}
