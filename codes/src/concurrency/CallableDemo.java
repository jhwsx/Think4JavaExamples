package concurrency;

import java.util.ArrayList;
import java.util.concurrent.*;

/**
 * 注意 submit 和 execute 的区别：
 *
 * <T> Future<T> submit(Callable<T> task);
 * void execute(Runnable command);
 *
 * @author wangzhichao
 * @since 2020/3/2
 */
class TaskWithResult implements Callable<String> {
    private int id;

    public TaskWithResult(int id) {
        this.id = id;
    }

    @Override
    public String call() throws Exception {
        Thread.sleep(5000L);
        return "result of TaskWithResult " + id;
    }
}

public class CallableDemo {
    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        ArrayList<Future<String>> results = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            results.add(exec.submit(new TaskWithResult(i)));
        }
        for (Future<String> fs : results) {
            try {
                // fs.isDone() 查询 Future 是否已经完成，它不阻塞。
                // get() 是阻塞的，直到完成：
                //if (fs.isDone()) {
                    System.out.println(fs.get());
                //}
            } catch (InterruptedException e) {
                e.printStackTrace();
                return;
            } catch (ExecutionException e) {
                e.printStackTrace();
            } finally {
                exec.shutdown();
            }
        }
    }
}
