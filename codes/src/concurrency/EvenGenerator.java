package concurrency;

/**
 * 偶数生成器
 *
 * @author wangzhichao
 * @since 2020/3/7
 */
public class EvenGenerator extends IntGenerator {
    private int currEvenValue = 0;

    @Override
    public int next() {
        ++currEvenValue; // 递增不是原子性操作：递增自身需要多个操作，在递增过程中任务可能会被线程挂起。
        Thread.yield(); // 添加这句代码，表示建议把 CPU 时间片切换给其他任务。
        ++currEvenValue; // 一个线程再次获取时间片，会从 Thread.yield() 的下一行开始运行。
        return currEvenValue;
    }

    public static void main(String[] args) {
        EvenChecker.test(new EvenGenerator(), 2);
    }
}
