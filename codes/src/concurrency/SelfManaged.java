package concurrency;

/**
 * 在 Runnable 实现类的构造方法中开启线程
 * 但这样并不好，因为毕竟 Runnable 实现类构造还没结束，就调用了 start 方法。
 *
 * @author wangzhichao
 * @since 2020/3/6
 */
public class SelfManaged implements Runnable {
    private int countDown = 5;
    private Thread thread = new Thread(this);

    public SelfManaged() {
        thread.start();
    }

    @Override
    public String toString() {
        return Thread.currentThread().getName() + "(" + countDown + ")";
    }

    @Override
    public void run() {
        while (true) {
            System.out.println(this);
            if (--countDown == 0) {
                return;
            }
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            new SelfManaged();
        }
    }
}
