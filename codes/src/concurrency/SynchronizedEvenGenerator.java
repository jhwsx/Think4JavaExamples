package concurrency;

/**
 * 同步的偶数生成器
 *
 * @author wangzhichao
 * @since 2020/3/7
 */
public class SynchronizedEvenGenerator extends IntGenerator {
    private int currEvenValue = 0;

    @Override
    public synchronized int next() {
        ++currEvenValue; // 递增不是原子性操作：递增自身需要多个操作，在递增过程中任务可能会被线程挂起。
        Thread.yield(); // 添加这句代码，表示建议把 CPU 时间片切换给其他任务。
        ++currEvenValue;
        // 如果这里发生了异常，那么内置锁将不能释放
//        if (currEvenValue  > 10000 && currEvenValue < 10009) {
//            throw new RuntimeException();
//        }
        return currEvenValue;
    }

    public static void main(String[] args) {
        EvenChecker.test(new SynchronizedEvenGenerator(),2);
    }
}
