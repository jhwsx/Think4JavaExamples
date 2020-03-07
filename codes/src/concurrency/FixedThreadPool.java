package concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author wangzhichao
 * @since 2020/3/2
 */
public class FixedThreadPool {
    public static void main(String[] args) {
        // 这种方法，可以预先执行代价高昂的线程分配
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 5; i++) {
            executorService.execute(new LiftOff());
        }
        executorService.shutdown();
        // 这一行不保证最后打印出来
        System.out.println("main end");
    }
}
