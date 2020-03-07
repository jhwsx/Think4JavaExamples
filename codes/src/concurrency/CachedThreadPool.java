package concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 使用 Executor，但是仍然有同步问题。
 * 管理 Thread 对象，简化并发编程。
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
        // Initiates an orderly shutdown in which previously submitted
        // tasks are executed, but no new tasks will be accepted.
        // 防止将新任务提交给这个 Executor。
        executorService.shutdown();
        // 在调用 shutdown 之后，又去添加任务报错：
        // Exception in thread "main" java.util.concurrent.RejectedExecutionException: Task concurrency.LiftOff@7f31245a rejected from java.util.concurrent.ThreadPoolExecutor@6d6f6e28[Shutting down, pool size = 0, active threads = 0, queued tasks = 0, completed tasks = 1]
        //	at java.util.concurrent.ThreadPoolExecutor$AbortPolicy.rejectedExecution(ThreadPoolExecutor.java:2063)
        //	at java.util.concurrent.ThreadPoolExecutor.reject(ThreadPoolExecutor.java:830)
        //	at java.util.concurrent.ThreadPoolExecutor.execute(ThreadPoolExecutor.java:1379)
        //	at concurrency.CachedThreadPool.main(CachedThreadPool.java:24)
        // executorService.execute(new LiftOff());
        // 这一行不保证最后打印出来
//        System.out.println("main end");
    }
}
