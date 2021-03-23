package concurrency.ex20;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * 使用 Executor，但是仍然有同步问题。
 * 管理 Thread 对象，简化并发编程。
 *
 * 修改 CachedThreadPool，使所有任务在结束之前都将收到一个 interrupt()
 *
 * @author wangzhichao
 * @since 2020/3/2
 */
public class CachedThreadPool {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < 5; i++) {
            executorService.execute(new LiftOff());
        }
        executorService.shutdownNow();
        System.out.println("----------------------------");
        ExecutorService executorService2 = Executors.newCachedThreadPool();
        List<Future<?>> futureList = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Future<?> future = executorService2.submit(new LiftOff());
            futureList.add(future);
        }
        // TODO 为什么要 sleep 一会儿，cancel 才能生效呢？
        try {
            TimeUnit.MILLISECONDS.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (Future<?> future : futureList) {
            future.cancel(true);
        }
    }
}
