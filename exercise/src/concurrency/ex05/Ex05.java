package concurrency.ex05;

import java.util.ArrayList;
import java.util.concurrent.*;

/**
 * @author wangzhichao
 * @since 2020/3/2
 */
class FibonacciCallable implements Callable<Integer> {

    private int n;
    public FibonacciCallable(int n) {
        this.n = n;
    }
    @Override
    public Integer call() throws Exception {
        Fibonacci gen = new Fibonacci();
        int result = 0;
        for (int i = 0; i < n; i++) {
            result += gen.next();
        }
        return result;
    }
}
public class Ex05 {

    public static void main(String[] args) {
        ExecutorService service = Executors.newCachedThreadPool();
        ArrayList<Future<Integer>> results = new ArrayList<>();
        for (int i = 1; i < 10; i++) {
            results.add(service.submit(new FibonacciCallable(i)));
        }
        for (Future<Integer> fi : results) {
            try {
                System.out.println(fi.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
                // 这里为什么要写 return 呢？
                return;
            } catch (ExecutionException e) {
                e.printStackTrace();
            } finally {
                service.shutdown();
            }
        }
    }
}
