package concurrency.ex04;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author wangzhichao
 * @since 2020/3/2
 */

public class CachedThreadPool {
    public static void main(String[] args) {
        ExecutorService newCachedThreadPool = Executors.newCachedThreadPool();
        for (int i = 1; i < 8; i++) {
            newCachedThreadPool.execute(new FibonacciRunnable(i));
        }
        newCachedThreadPool.shutdown();
    }
}
