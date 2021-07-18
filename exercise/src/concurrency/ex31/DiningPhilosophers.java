package concurrency.ex31;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * 修改 DeadlockingDiningPhilosophers.java，使得当哲学家用完筷子之后，把筷子放在一个筷笼里。
 * 当哲学家要就餐的时候，他们就从筷笼里取出两根可用的筷子。这消除了死锁的可能吗？你能仅仅通过减少
 * 可用的筷子数目就重新引入死锁吗？
 *
 * 使用阻塞队列来实现，消除死锁；不能通过减少可用的筷子数目就重新引入死锁。
 *
 * @author wangzhichao
 * @since 2021/4/9
 */
public class DiningPhilosophers {
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
        LinkedBlockingQueue<Chopstick> chopstickLinkedBlockingQueue = new LinkedBlockingQueue<>();
        for (int i = 0; i < size; i++) {
            chopstickLinkedBlockingQueue.put(new Chopstick(i));
        }
        for (int i = 0; i < size; i++) {
            exec.execute(new Philosopher(chopstickLinkedBlockingQueue, i, ponder));
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
