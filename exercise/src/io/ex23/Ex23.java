package io.ex23;

import java.nio.CharBuffer;

/**
 * 创建并测试一个实用方法，使其可以打印出 CharBuffer 中的内容，直到字符不能再打印为止。
 *
 * @author wangzhichao
 * @since 2021/7/24
 */
public class Ex23 {
    public static void main(String[] args) {
        char[] ca = "hello,world!".toCharArray();
        CharBuffer cb = CharBuffer.wrap(ca);
        printCharBuffer(cb);
        CharBuffer cb2 = CharBuffer.allocate(6);
        cb2.put("good".toCharArray());
        printCharBuffer(cb2);
        char[] ca3 = {(char) 0x01, (char) 0x07, (char) 0x7F, 'b', 'y', 'e'};
        CharBuffer cb3 = CharBuffer.wrap(ca3);
        printCharBuffer(cb3);
    }

    private static void printCharBuffer(CharBuffer cb) {
        // 该方法实际上并没有擦除缓冲区中的数据
        // 参考：https://vimsky.com/examples/usage/charbuffer-clear-methods-in-java-with-examples.html
        cb.clear();
        while (cb.hasRemaining()) {
            char ch = cb.get();
            if (isPrintable(ch)) {
                System.out.print(ch);
            }
        }
        System.out.println();
    }

    private static boolean isPrintable(char c) {
        return c >= '!' && c <= '~';
    }
}
