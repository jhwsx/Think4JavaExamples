package io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringReader;

/**
 * 文本文件输出的快捷方式
 *
 * @author wangzhichao
 * @since 2021/7/17
 */
public class FileOutputShortcut {
    static final String file = "FileOutputShortcut.out";
    public static void main(String[] args) throws IOException {
        String read = BufferedInputFile.read("D:\\Android\\Workspace\\github\\Think4JavaExamples\\codes\\src\\io\\FileOutputShortcut.java");
        StringReader stringReader = new StringReader(read);
        BufferedReader bufferedReader = new BufferedReader(stringReader);
        PrintWriter printWriter = new PrintWriter(file);
        String s;
        int lineCount = 1;
        while ((s = bufferedReader.readLine()) != null) {
            printWriter.println(lineCount++ + ":" + s);
        }
        printWriter.close();
        System.out.println(BufferedInputFile.read(file));
    }
}
