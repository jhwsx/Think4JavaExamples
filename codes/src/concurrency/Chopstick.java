package concurrency;

/**
 * 一根筷子
 *
 * @author wangzhichao
 * @since 2021/4/9
 */
public class Chopstick {
    private boolean taken = false;
    public synchronized void take() throws InterruptedException {
        while (taken) {
            wait();
        }
        taken = true;
    }

    public synchronized void drop() {
        taken = false;
        notifyAll();
    }
}
