package concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 在主线程想要捕获子线程的异常是不可能的，它们在不同的执行路径上。
 *
 * @author wangzhichao
 * @since 2020/3/7
 */
public class NaiveExceptionHandling {
    public static void main(String[] args) {
        try {
            ExecutorService exec = Executors.newCachedThreadPool();
            exec.execute(new ExceptionThread());
        } catch (RuntimeException e) {
            System.out.println("Exception has been handled.");
        }
    }
}
