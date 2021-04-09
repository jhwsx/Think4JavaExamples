package concurrency.ex31;

import java.util.Random;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * 一个在用餐的哲学家
 *
 * @author wangzhichao
 * @since 2021/4/9
 */
public class Philosopher implements Runnable {

    private final int id;
    /**
     * ponder 是思索的意思
     */
    private final int ponderFactor;
    private final Random rand = new Random(47);
    private LinkedBlockingQueue<Chopstick> blockingQueue;

    public Philosopher(LinkedBlockingQueue<Chopstick> blockingQueue, int i, int ponder) {
        this.id = i;
        this.ponderFactor = ponder;
        this.blockingQueue = blockingQueue;
    }

    private void pause() throws InterruptedException {
        // ponderFactor 不为 0 时，哲学家会在思考上花掉一段随机化的时间。
        if (ponderFactor == 0) return;
        TimeUnit.MILLISECONDS.sleep(rand.nextInt(ponderFactor * 250));
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                System.out.println(this + " " + "thinking");
                pause();
                // 哲学家饿了
                System.out.println(this + " " + "grabbing two chopsticks");
                if (blockingQueue.size() < 2) {
                    System.out.println(this + " " + "available chopsticks: " + blockingQueue.size());
                    continue;
                }
                Chopstick chopstick1 = blockingQueue.take();
                System.out.println(this + " " + "holding " + chopstick1);
                Chopstick chopstick2 = blockingQueue.take();
                System.out.println(this + " " + "holding " + chopstick2);
                System.out.println(this + " " + "eating");
                pause();
                blockingQueue.put(chopstick1);
                System.out.println(this + " " + "drop " + chopstick1);
                blockingQueue.put(chopstick2);
                System.out.println(this + " " + "drop " + chopstick2);
            }
        } catch (InterruptedException e) {
            System.out.println(this + " " + "exiting via interrupt");
        }
    }

    @Override
    public String toString() {
        return "Philosopher " + id;
    }
}
