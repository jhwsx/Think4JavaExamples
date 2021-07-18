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
        PrintWriter printWriter = new PrintWriter(System.out, true);
        printWriter.println("Hello, world!");
    }
}
