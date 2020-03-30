package concurrency;

import java.util.Arrays;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * 这个例子说明 volatile 并不能保证 SerialNumberGenerator 中的
 * 递增操作是原子性操作。
 *
 * @author wangzhichao
 * @since 2020/3/9
 */
// 复用存储这样我们就不会耗尽内存空间
class CircularSet {
    private int[] array;
    private int len;
    private int index = 0;

    public CircularSet(int size) {
        // 创建一个大小为 size 的数组
        array = new int[size];
        len = size;
        // Initialize to a value not produced
        // by the SerialNumberGenerator
        // 初始化数组的元素值为 -1，这个值不会为 SerialNumberGenerator 所产生。
        for (int i = 0; i < size; i++) {
            array[i] = -1;
        }
    }

    // 添加一个元素的方法
    public synchronized void add(int i) {
        array[index] = i;
        // Wrap index and write over old elements.
        // 包装索引并覆盖旧元素。
        index = ++index % len;
    }

    // 判断是否包含一个值的方法
    public synchronized boolean contains(int val) {
        for (int i = 0; i < len; i++) {
            if (array[i] == val) {
                return true;
            }
        }
        return false;
    }
}

public class SerialNumberChecker {
    private static final int SIZE = 10;
    // 声明一个 static 的 CircularSet 对象
    private static CircularSet serials =
            new CircularSet(1000);
    private static ExecutorService exec =
            Executors.newCachedThreadPool();

    // 这是一个 Runnable 的实现类，嵌套类。
    static class SerialChecker implements Runnable {

        @Override
        public void run() {
            while (true) {
                // 生成下一个序列数字
                int serial =
                        SerialNumberGenerator.nextSerialNumber();
                System.out.println("serial = " + serial);
                if (serials.contains(serial)) {
                    // 判断在集合中已经存在，就打印重复的序列数字，并退出应用。
                    System.out.println("Duplicate: " + serial);
                    System.exit(0);
                }
                // 判断集合中不存在，就把生成的序列数字添加到集合中。
                serials.add(serial);
            }
        }
    }

    public static void main(String[] args) throws Exception {
        // 创建多个任务来竞争序列数。
        for (int i = 0; i < SIZE; i++) {
            exec.execute(new SerialChecker());
        }
        // 没有传参，这里进不去
        if (args.length > 0) {
            TimeUnit.SECONDS.sleep(new Integer(args[0]));
            System.out.println("No duplicates detected");
            System.exit(0);
        }
    }
}