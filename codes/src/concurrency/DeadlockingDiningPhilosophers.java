package concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * 展示在一个程序中死锁如何被隐藏
 * ponder 越小，表示哲学家花在思考上的时间越少。ponder 为 0，为了使死锁尽快发生。
 *
 * 每个哲学家都拿起了右边的筷子，并在等待左边的筷子，这就会形成死锁。
 *
 * @author wangzhichao
 * @since 2021/4/9
 */
public class DeadlockingDiningPhilosophers {
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
            exec.execute(new Philosopher(sticks[i], sticks[(i + 1) % size], i, ponder));
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
