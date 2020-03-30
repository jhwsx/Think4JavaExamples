package concurrency.ex13;

/**
 * 这个类用于产生序列数字
 *
 * @author wangzhichao
 * @since 2020/3/9
 */
public class SerialNumberGenerator {
    // 当一个共享变量被 volatile 修饰时，它会保证修改的值会立即被更新到主存中，
    // 当其他线程需要读取时，会从内存中读取新值。
    private static volatile int serialNumber = 0;

    // 预期的是每次返回的值都是不一样的
    // 需要加上 synchronized 关键字才可以保证原子性。
    public static synchronized int nextSerialNumber() {
        // 注意：在 Java 中，递增不是原子性操作,即便是加了 volatile 也
        // 无法保证。
        return serialNumber++;
    }
}