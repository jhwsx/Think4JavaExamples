package io.ex14;

import io.ex13.BufferedInputFile;

import java.io.*;

/**
 * 从 BasicFileOutput.java 的第四部分开始，编写一个程序，用来比较有缓冲的
 * 和无缓冲的I/O方式在文件写入时的性能差别。
 *
 * @author wangzhichao
 * @since 2021/7/18
 */
public class Ex14 {
    static String file = "BasicFileOutput.out";

    public static void main(String[] args) throws IOException {
        withBuffer();
        withoutBuffer();
    }

    public static void withBuffer() throws IOException {
        BufferedReader in = new BufferedReader(
                new StringReader(BufferedInputFile.read("D:\\Android\\Workspace\\github\\Think4JavaExamples\\codes\\src\\io\\BasicFileOutput.java"))
        );
        PrintWriter out = new PrintWriter(
                new BufferedWriter(
                        new FileWriter(file)
                )
        );
        String line;
        long start = System.nanoTime();
        int lineCount = 1;
        while ((line = in.readLine()) != null) {
            out.println(lineCount++ + ":" + line);
        }
        out.close();
        in.close();
        long end = System.nanoTime();

        System.out.println("withBuffer cost: " + (end - start));
    }

    public static void withoutBuffer() throws IOException {
        BufferedReader in = new BufferedReader(
                new StringReader(BufferedInputFile.read("D:\\Android\\Workspace\\github\\Think4JavaExamples\\codes\\src\\io\\BasicFileOutput.java"))
        );
        PrintWriter out = new PrintWriter(
                new FileWriter(file)
        );
        String line;
        long start = System.nanoTime();
        int lineCount = 1;
        while ((line = in.readLine()) != null) {
            out.println(lineCount++ + ":" + line);
        }
        out.close();
        in.close();
        long end = System.nanoTime();
        System.out.println("withoutBuffer cost: " + (end - start));
    }
}
