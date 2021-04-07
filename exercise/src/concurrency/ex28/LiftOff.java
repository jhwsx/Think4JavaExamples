package concurrency.ex28;

/**
 * Runnable 接口是描述任务的方式
 *
 * @author wangzhichao
 * @since 2020/3/2
 */
public class LiftOff implements Runnable {
    protected int countDown = 10;
    private static int taskCount = 0;
    private final int id = taskCount++;

    public LiftOff() {}

    public LiftOff(int countDown) {
        this.countDown = countDown;
    }

    public String status() {
        return "#" + id + "(" +
                (countDown > 0 ? countDown : "LiftOff!") + "), ";
    }
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
        while (countDown-- > 0) {
            System.out.print(status());
            // Thread.yield() 的作用是给线程调度器一个建议：把时间片切换给其他任务吧。
            Thread.yield();
        }
    }
}
