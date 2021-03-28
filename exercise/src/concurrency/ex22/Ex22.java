package concurrency.ex22;

/**
 * @author wangzhichao
 * @since 2021/3/29
 */

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Create an example of a busy wait. One task sleeps for a while and
 * then sets a flag to true. The second task watches that flag inside
 * a while loop (this is the busy wait) and when the flag becomes true,
 * sets it back to false and reports the change to the console. Note
 * how much wasted time the program spends inside the busy wait, and
 * create a second version of the program that uses wait() instead of
 * the busy wait.
 **/
class FlagBean {
    private volatile boolean flag = false;

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public boolean isFlag() {
        return flag;
    }
}

class Runnable1 implements Runnable {

    private FlagBean flagBean;

    public Runnable1(FlagBean flagBean) {
        this.flagBean = flagBean;
    }

    @Override
    public void run() {
        synchronized (flagBean) {
            System.out.println("Runnable1 run() start");
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Runnable1 setFlag(true)");
            flagBean.setFlag(true);
        }
    }
}

class Runnable2 implements Runnable {
    private FlagBean flagBean;

    public Runnable2(FlagBean flagBean) {
        this.flagBean = flagBean;
    }

    private long firstLoopTimeMillis = 0L;

    @Override
    public void run() {
        while (true) {
            if (firstLoopTimeMillis == 0L) {
                firstLoopTimeMillis = System.currentTimeMillis();
            }
            synchronized (flagBean) { // 没有获取到锁之前，会阻塞在这里
                System.out.println("busy wait: " + ((System.currentTimeMillis() - firstLoopTimeMillis) / 1000));
                if (flagBean.isFlag()) {
                    flagBean.setFlag(false);
                    System.out.println("I have changed the flag.");
                    break;
                }
            }
        }
    }
}

public class Ex22 {
    public static void main(String[] args) {
        ExecutorService threadPool = Executors.newCachedThreadPool();
        FlagBean flagBean = new FlagBean();
        threadPool.execute(new Runnable1(flagBean));
        threadPool.execute(new Runnable2(flagBean));
        threadPool.shutdown();
    }
}
