package concurrency;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 这里使用 AtomicInteger 来替代 MutexEvenGenerator 中的 Lock
 *
 * @author wangzhichao
 * @since 2020/3/12
 */
public class AtomicEvenGenerator extends IntGenerator {
    private AtomicInteger currEvenValue = new AtomicInteger(0);
    @Override
    public int next() {
        return currEvenValue.getAndAdd(2);
    }

    public static void main(String[] args) {
        EvenChecker.test(new AtomicEvenGenerator());
    }
}
