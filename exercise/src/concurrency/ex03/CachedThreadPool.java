package concurrency.ex03;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 会创建与所需数量相同的线程
 * @author wangzhichao
 * @since 2020/3/2
 */

public class CachedThreadPool {
    public static void main(String[] args) {
        ExecutorService newCachedThreadPool = Executors.newCachedThreadPool();
        for (int i = 0; i < 5; i++) {
            newCachedThreadPool.execute(new MyRunnable(i));
        }
        newCachedThreadPool.shutdown();
    }
}
