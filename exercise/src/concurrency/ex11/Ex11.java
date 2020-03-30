package concurrency.ex11;

import net.mindview.util.RandomGenerator;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author wangzhichao
 * @since 2020/3/7
 */
class Data {
    private int a;
    private int b;
    private boolean canceled = false;

    public synchronized void operate(int a, int b) {
        this.a = a;
        this.b = b;
        Thread.yield();
        this.a = this.a - this.a;
        Thread.yield();
        this.b = this.b - this.b;
    }
    // 需要注意的是 getSum 也要加上锁，因为加法不是原子操作。
    public synchronized int getSum() {
        return a + b;
    }

    public void cancel() {
        canceled = true;
    }
    public boolean isCanceled() {
        return canceled;
    }
}

class MyRunnable implements Runnable {
    private Data data;
    private RandomGenerator.Integer generator;

    public MyRunnable(Data data, RandomGenerator.Integer generator) {
        this.data = data;
        this.generator = generator;
    }

    @Override
    public void run() {
        while (!data.isCanceled()) {
            data.operate(generator.next(), generator.next());
            int value = data.getSum();
            if (value != 0) {
                data.cancel();
                System.out.println("...........................Fail");
            } else {
                System.out.println("Success............");
            }
        }

    }
}
public class Ex11 {
    public static void main(String[] args) {
        // 创建共享资源
        Data data = new Data();
        RandomGenerator.Integer generator = new RandomGenerator.Integer();
        ExecutorService exec = Executors.newCachedThreadPool();
        for (int i = 0; i < 10; i++) {
            exec.execute(new MyRunnable(data, generator));
        }
        exec.shutdown();
    }
}
