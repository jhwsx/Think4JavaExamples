package io;

import java.io.PrintWriter;

/**
 * 将 System.out 转换为 PrintWriter
 *
 * @author wangzhichao
 * @since 2021/7/18
 */
public class ChangeSystemOut {
    public static void main(String[] args) {
        // System.out 是一个 PrintStream 对象，PrintStream 是 InputStream 的子类；
        // 而 PrintWriter 可以接收一个 InputStream 对象。
        PrintWriter printWriter = new PrintWriter(System.out, true);
        printWriter.println("Hello, world!");
    }
}
