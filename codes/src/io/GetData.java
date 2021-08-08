package io;

import java.nio.ByteBuffer;

/**
 * 使用 ByteBuffer 的各种方法来插入和抽取各种数值
 *
 * @author wangzhichao
 * @since 2021/8/8
 */
public class GetData {
    private static final int BSIZE = 1024;

    public static void main(String[] args) {
        ByteBuffer bb = ByteBuffer.allocate(1024);
        // 自动给 ByteBuffer 里的元素分配为 0
        int i = 0;
        // limit 方法：返回此缓冲区的限制
        while (i < bb.limit()) {
            if (bb.get() != 0) {
                System.out.println("nonzero");
            }
            i++;
        }
        System.out.println("i = " + i);
        // 重绕此缓冲区。将位置设置为 0 并丢弃标记。
        bb.rewind();


        // 存储并读取一个字符数组
        bb.asCharBuffer().put("Howdy");
        char c;
        while ((c = bb.getChar()) != 0) {
            System.out.print(c + " ");
        }
        System.out.println();
        bb.rewind();

        // 存储并读取一个短整型
        bb.asShortBuffer().put((short) 10086);
        System.out.println(bb.getShort());
        bb.rewind();

        // 存储并读取一个整型
        bb.asIntBuffer().put(Integer.MAX_VALUE);
        System.out.println(bb.getInt());
        bb.rewind();

        // 存储并读取一个长整型
        bb.asLongBuffer().put(Long.MAX_VALUE);
        System.out.println(bb.getLong());
        bb.rewind();

        // 存储并读取一个浮点型
        bb.asFloatBuffer().put(6.18F);
        System.out.println(bb.getFloat());
        bb.rewind();

        // 存储并读取一个双精度型
        bb.asDoubleBuffer().put(Math.PI);
        System.out.println(bb.getDouble());
        bb.rewind();
    }
}
