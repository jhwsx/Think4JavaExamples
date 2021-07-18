package concurrency;

import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * 一个在用餐的哲学家
 *
 * @author wangzhichao
 * @since 2021/4/9
 */
public class Philosopher implements Runnable {

    private Chopstick left;
    private Chopstick right;
    private final int id;
    /**
     * ponder 是思索的意思
     */
    private final int ponderFactor;
    private final Random rand = new Random(47);

    private void pause() throws InterruptedException {
        // ponderFactor 不为 0 时，哲学家会在思考上花掉一段随机化的时间。
        if (ponderFactor == 0) return;
        TimeUnit.MILLISECONDS.sleep(rand.nextInt(ponderFactor * 250));
    }

    public Philosopher(Chopstick left, Chopstick right, int ident, int ponder) {
        this.left = left;
        this.right = right;
        this.id = ident;
        this.ponderFactor = ponder;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                System.out.println(this + " " + "thinking");
                pause();
                // 哲学家饿了
                System.out.println(this + " " + "grabbing right");
                right.take();
                System.out.println(this + " " + "grabbing left");
                left.take();
                System.out.println(this + " " + "eating");
                pause();
                right.drop();
                left.drop();
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
