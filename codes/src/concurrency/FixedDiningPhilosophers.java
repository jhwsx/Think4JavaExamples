package concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 打破循环等待条件，来解决死锁问题
 *
 * @author wangzhichao
 * @since 2021/4/9
 */
public class FixedDiningPhilosophers {
    public static void main(String[] args) throws Exception {
        args = new String[]{"0", "5", "timeout"};
        int ponder = 5;
        if (args.length > 0) {
            ponder = Integer.parseInt(args[0]);
        }
        int size = 5;
        if (args.length > 1) {
            size = Integer.parseInt(args[1]);
        }
        ExecutorService exec = Executors.newCachedThreadPool();
        Chopstick[] sticks = new Chopstick[size];
        for (int i = 0; i < size; i++) {
            sticks[i] = new Chopstick();
        }
        for (int i = 0; i < size; i++) {
            if (i < (size - 1)) {
                exec.execute(new Philosopher(sticks[i], sticks[(i + 1) % size], i, ponder));
            } else {
                // 最后一个哲学家先拿左边的筷子，再拿右边的筷子
                exec.execute(new Philosopher(sticks[0], sticks[1], i, ponder));
            }
        }
        // 觉得注释掉，更容易看出效果。
//        if (args.length == 3 && args[2].equals("timeout")) {
//            TimeUnit.SECONDS.sleep(5);
//        } else {
//            System.out.println("Press 'Enter' to quit");
//            System.in.read();
//        }
//        exec.shutdownNow();
    }
}
