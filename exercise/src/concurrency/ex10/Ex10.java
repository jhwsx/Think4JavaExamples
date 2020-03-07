package concurrency.ex10;

import java.util.ArrayList;
import java.util.concurrent.*;

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

public class Ex10 {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        System.out.println(runTask(1));
        System.out.println(runTask(2));
        System.out.println(runTask(3));
        System.out.println(runTask(4));
        System.out.println(runTask(5));
        System.out.println(runTask(6));
    }

    public static int runTask(int num) throws ExecutionException, InterruptedException {
        ExecutorService service = Executors.newCachedThreadPool();
        Future<Integer> future = service.submit(new FibonacciCallable(num));
        try {
           return future.get();
        } finally {
            service.shutdown();
        }
    }
}
