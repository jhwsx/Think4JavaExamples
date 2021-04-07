package concurrency.ex28;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.SynchronousQueue;

/**
 * 修改 TestBlockingQueue.java，添加一个将 LiftOff 放置到 BlockingQueue 中的任务，而不要放置在 main() 中。
 *
 * @author wangzhichao
 * @since 2021/4/7
 */
class LiftOffRunner implements Runnable {

    private final BlockingQueue<LiftOff> rockets;

    public LiftOffRunner(BlockingQueue<LiftOff> queue) {
        rockets = queue;
    }

    public void add(LiftOff lo) {
        try {
            rockets.put(lo);
        } catch (InterruptedException e) {
            System.out.println("Interrupted during put()");
        }
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                LiftOff rocket = rockets.take();
                rocket.run();
            }
        } catch (InterruptedException e) {
            System.out.println("Waking from take()");
        }
        System.out.println("Exiting LiftOffRunner");
    }
}

class LiftOffAdder implements Runnable {
    private LiftOffRunner runner;

    LiftOffAdder(LiftOffRunner runner) {
        this.runner = runner;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            runner.add(new LiftOff(5));
        }
    }
}
public class TestBlockingQueues {
    static void getkey() {
        try {
            // Compensate for Window/Linux difference in the length of the
            // result produced by the Enter key:
            new BufferedReader(new InputStreamReader(System.in)).readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    static void getkey(String message) {
        System.out.println(message);
        getkey();
    }

    static void test(String msg, BlockingQueue<LiftOff> queue) {
        System.out.println(msg);
        LiftOffRunner runner = new LiftOffRunner(queue);
        Thread t = new Thread(runner);
        t.start();
        LiftOffAdder liftOffAdder = new LiftOffAdder(runner);
        Thread t2 = new Thread(liftOffAdder);
        t2.start();
        getkey("Press 'Enter' (" + msg + ")");
        t.interrupt();
        System.out.println("Finished " + msg + " test");
    }

    public static void main(String[] args) {
        test("LinkedBlockingQueue", new LinkedBlockingQueue<>()); // 不限制容量
        test("ArrayBlockingQueue", new ArrayBlockingQueue<>(3)); // 固定容量
        test("SynchronousQueue", new SynchronousQueue<>()); // 容量为1

    }
}
