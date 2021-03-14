package concurrency.ex03;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 会预先创建有限的线程集
 *
 * @author wangzhichao
 * @since 2020/3/2
 */
public class FixedThreadPool {
    public static void main(String[] args) {
        ExecutorService newFixedThreadPool = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 5; i++) {
            newFixedThreadPool.execute(new MyRunnable(i));
        }
        newFixedThreadPool.shutdown();
    }
}
