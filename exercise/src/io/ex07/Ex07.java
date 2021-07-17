package io.ex07;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collections;
import java.util.LinkedList;
import java.util.ListIterator;

/**
 * 打开一个文本文件，每次读取一行内容。将每行作为一个 String 读入，并将那个 String 对象置入一个 LinkedList 中。
 * 按相反的顺序打印出 LinkedList 中的所有行。
 *
 * @author wangzhichao
 * @since 2021/7/17
 */
public class Ex07 {
    public static void main(String[] args) throws IOException {
        FileReader fileReader = new FileReader("D:\\Android\\Workspace\\github\\Think4JavaExamples\\exercise\\src\\io\\ex07\\Ex07.java");
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String line;
        LinkedList<String> lineList = new LinkedList<>();
        while((line = bufferedReader.readLine()) != null) {
            lineList.add(line);
        }
        bufferedReader.close();
        Collections.reverse(lineList);
        for (String s : lineList) {
            System.out.println(s);
        }
    }
}
