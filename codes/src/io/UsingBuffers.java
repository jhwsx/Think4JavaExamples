package io;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;

/**
 * 使用交互相邻字符的方法对 CharBuffer 中的字符进行编码（scramble）和解码（unscramble）
 *
 * @author wangzhichao
 * @since 2021/8/8
 */
public class UsingBuffers {
    public static void main(String[] args) {
        char[] data = "UsingBuffers".toCharArray();
        ByteBuffer bb = ByteBuffer.allocate(data.length * 2);
        CharBuffer cb = bb.asCharBuffer();
        cb.put(data);
        System.out.println(cb.rewind());
        symmetricScramble(cb);
        // rewind方法：重绕此缓冲区。将位置设置为 0 并丢弃标记。
        System.out.println(cb.rewind());
        symmetricScramble(cb);
        System.out.println(cb.rewind());
    }

    private static void symmetricScramble(CharBuffer buffer) {
        while (buffer.hasRemaining()) {
            // 在此缓冲区的位置设置标记。
            buffer.mark();
            // 相对 get 方法。读取此缓冲区当前位置的字符，然后该位置递增。
            char c1 = buffer.get();
            char c2 = buffer.get();
            // 将此缓冲区的位置重置为以前标记的位置。调用此方法不更改也不丢弃标记的值。
            buffer.reset();
            // 相对 put 方法（可选操作）。 将给定字符写入此缓冲区的当前位置，然后该位置递增。
            buffer.put(c2).put(c1);
        }
    }
}
