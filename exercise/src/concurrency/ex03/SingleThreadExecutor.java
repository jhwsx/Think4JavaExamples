package concurrency.ex03;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 这就是线程数量为 1 的 线程池
 *
 * @author wangzhichao
 * @since 2020/3/2
 */
public class SingleThreadExecutor {
    public static void main(String[] args) {
        ExecutorService newSingleThreadExecutor = Executors.newSingleThreadExecutor();
        for (int i = 0; i < 5; i++) {
            newSingleThreadExecutor.execute(new MyRunnable(i));
        }
        newSingleThreadExecutor.shutdown();
    }
}
