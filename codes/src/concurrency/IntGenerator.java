package concurrency;

/**
 * int 类型数据的生成器类
 * <p>
 * 这里没有实现自 Generator 接口，这是因为这里必须要返回一个 int 类型的返回值，而泛型不支持基本类型的参数。
 * 这里还包含了设置 cancel 以及读取 cancel 的方法。
 *
 * @author wangzhichao
 * @since 2020/3/7
 */
public abstract class IntGenerator {
    // 对 canceled 的操作是原子性的，即采取赋值和获取返回值这样的简单操作时没有中断的可能。
    // 加上 volatile 是为了保证可视性。
    private volatile boolean canceled = false;

    public abstract int next();

    public void cancel() {
        canceled = true;
    }

    public boolean isCanceled() {
        return canceled;
    }
}
