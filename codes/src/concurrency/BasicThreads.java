package concurrency;

/**
 * @author wangzhichao
 * @since 2020/3/2
 */
public class BasicThreads {
    public static void main(String[] args) {
        Thread t = new Thread(new LiftOff());
        t.start();
        System.out.println("Waiting for LiftOff!");
    }
}
