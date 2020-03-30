package concurrency.ex12;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 检验生成的数字是 4 的倍数，如果不是，程序就退出。
 *
 * @author wangzhichao
 * @since 2020/3/10
 */
class MyRunnable implements Runnable {
    private final Atomicity atomicity;

    public MyRunnable(Atomicity atomicity) {
        this.atomicity = atomicity;
    }

    @Override
    public void run() {
        while (true) {
            // 注意，连续调用两个同步方法不能保证同步
//                atomicity.f1();
            atomicity.f2();
            int i = atomicity.get();
            System.out.println("i = " + i);
            if (i % 3 != 0) {
                System.out.println("atomicity.i % 4 != 0, i = " + i);
                System.exit(0);
            }
        }
    }
}

public class Ex12 {
    public static void main(String[] args) {
        Atomicity atomicity = new Atomicity();
        ExecutorService exec = Executors.newCachedThreadPool();
        for (int i = 0; i < 10; i++) {
            exec.execute(new MyRunnable(atomicity));
        }
        exec.shutdown();
    }
}
