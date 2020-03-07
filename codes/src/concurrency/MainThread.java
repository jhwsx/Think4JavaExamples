package concurrency;

/**
 * @author wangzhichao
 * @since 2020/3/2
 */
public class MainThread {
    public static void main(String[] args) {
        LiftOff launch = new LiftOff();
        launch.run();
    }
}
