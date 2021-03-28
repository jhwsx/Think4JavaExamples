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
class Flag {
    private volatile boolean flag = false;

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public boolean isFlag() {
        return flag;
    }
}

class Runnable3 implements Runnable {

    private Flag flagBean;

    public Runnable3(Flag flagBean) {
        this.flagBean = flagBean;
    }

    @Override
    public void run() {
        synchronized (flagBean) {
            System.out.println("Runnable3 run() start");
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Runnable3 setFlag(true)");
            flagBean.setFlag(true);
            System.out.println("Runnable3 notify");
            flagBean.notify();
        }

    }
}

class Runnable4 implements Runnable {
    private Flag flagBean;

    public Runnable4(Flag flagBean) {
        this.flagBean = flagBean;
    }

    @Override
    public void run() {
        synchronized (flagBean) {
            while(!flagBean.isFlag()) {
                try {
                    flagBean.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            flagBean.setFlag(false);
            System.out.println("I have changed the flag.");
        }
    }
}

public class Ex22Fix {
    public static void main(String[] args) {
        ExecutorService threadPool = Executors.newCachedThreadPool();
        Flag flagBean = new Flag();
        threadPool.execute(new Runnable3(flagBean));
        threadPool.execute(new Runnable4(flagBean));
        threadPool.shutdown();
    }
}
