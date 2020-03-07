package concurrency;

/**
 * @author wangzhichao
 * @since 2020/3/2
 */
public class MoreBasicThreads {
    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            new Thread(new LiftOff()).start();
        }
        System.out.println("Waiting for LiftOff!");
    }
}
