package io.ex24;

import java.nio.ByteBuffer;
import java.nio.DoubleBuffer;
import java.nio.IntBuffer;

/**
 * 演示通过DoubleBuffer操纵ByteBuffer中的double型数据
 *
 * @author wangzhichao
 * @since 2021/8/8
 */
public class DoubleBufferDemo {
    private static final int BSIZE = 1024;

    public static void main(String[] args) {
        ByteBuffer bb = ByteBuffer.allocate(BSIZE);
        DoubleBuffer ib = bb.asDoubleBuffer();
        // 存储一个double型数组
        ib.put(new double[]{11, 42, 47, 99, 143, 811, 1016});
        // 从绝对位置读
        System.out.println("ib.get(3) = " + ib.get(3));
        // 向绝对位置写
        ib.put(3, 1811);
        // 它将限制设置为当前位置，然后将位置设置为 0
        ib.flip();
        while (ib.hasRemaining()) {
            double i = ib.get();
            System.out.println(i);
        }
    }
}
