package concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 不能盲目依赖原子性
 *
 * @author wangzhichao
 * @since 2020/3/9
 */
public class AtomicityTest implements Runnable {
    private int i;
    // 这种不加 synchronized 关键字的，容易出现线程安全问题。
    // 在这个例子中虽然 return i; 是原子性操作，但是缺少同步
    // 使得它的值可以在处于不稳定的中间状态时而被读取。
//    public int getValue() {
//        return i;
//    }

    // 需要加上 synchronized 关键字才可以。
    public synchronized int getValue() {
        return i;
    }

    private synchronized void evenIncrement() {
        i++;
        i++;
    }

    @Override
    public void run() {
        while (true) {
            evenIncrement();
        }
    }

    public static void main(String[] args) {
        AtomicityTest atomicityTest = new AtomicityTest();
        ExecutorService exec = Executors.newCachedThreadPool();
        exec.execute(atomicityTest);
        exec.shutdown();

        while (true) {
            int value = atomicityTest.getValue();
            System.out.println(value);
            if (value % 2 != 0) {
                System.out.println(value + "is an odd number");
                System.exit(0);
            }
        }
    }
}
