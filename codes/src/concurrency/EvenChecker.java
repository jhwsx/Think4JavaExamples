package concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 消费者任务：用来检查偶数的
 *
 * @author wangzhichao
 * @since 2020/3/7
 */
public class EvenChecker implements Runnable {

    private IntGenerator gp;
    private int id;

    public EvenChecker(IntGenerator gp, int ident) {
        this.gp = gp;
        this.id = ident;
    }

    @Override
    public void run() {
        while (!gp.isCanceled()) {
            // 获取数字
            int value = gp.next();
            System.out.println(Thread.currentThread().getName() + ", value = " + value);
            if (value % 2 != 0) {
                // 不是个偶数
                System.out.println(value + " not even");
                // TODO 任务依赖于非任务对象，消除了潜在的竞争条件。为什么？
                gp.cancel(); // 这句是终止信号，其实就是结束了所有的 EvenChecker 任务。
            }
        }
    }

    public static void test(IntGenerator gp, int count) {
        System.out.println("Press Ctrl+C to exit.");
        ExecutorService exec = Executors.newCachedThreadPool();
        for (int i = 0; i < count; i++) {
            exec.execute(new EvenChecker(gp, i));
        }
        exec.shutdown();
    }

    public static void test(IntGenerator gp) {
        test(gp, 10);
    }
}
