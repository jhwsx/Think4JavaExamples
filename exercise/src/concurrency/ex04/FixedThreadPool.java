package concurrency.ex04;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author wangzhichao
 * @since 2020/3/2
 */
public class FixedThreadPool {
    public static void main(String[] args) {
        ExecutorService newFixedThreadPool = Executors.newFixedThreadPool(6);
        for (int i = 1; i < 8; i++) {
            newFixedThreadPool.execute(new FibonacciRunnable(i));
        }
        newFixedThreadPool.shutdown();
    }
}
