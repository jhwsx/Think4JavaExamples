package io;

import java.io.IOException;
import java.io.StringReader;

/**
 * 从内存输入
 *
 * @author wangzhichao
 * @since 2021/7/17
 */
public class MemoryInput {
    public static void main(String[] args) throws IOException {
        String s = BufferedInputFile.read("D:\\Android\\Workspace\\github\\Think4JavaExamples\\codes\\src\\io\\MemoryInput.java");
        StringReader stringReader = new StringReader(s);
        int c;
        while ((c = stringReader.read()) != -1) {
            System.out.println(((char) c));
        }
    }
}
