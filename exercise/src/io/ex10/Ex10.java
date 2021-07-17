package io.ex10;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collections;
import java.util.LinkedList;

/**
 * 修改练习8，令它接收附加的命令行参数，用来表示要在文件中查找的单词。打印出包含了欲查找单词的所有文本行。
 *
 * @author wangzhichao
 * @since 2021/7/17
 */
public class Ex10 {
    public static void main(String[] args) throws IOException {
        if (args.length == 0) {
            System.err.println("Please input fileName as args");
            System.exit(1);
        }
        FileReader fileReader = new FileReader(args[0]);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String line;
        LinkedList<String> lineList = new LinkedList<>();
        while((line = bufferedReader.readLine()) != null) {
            for (int i = 1; i < args.length; i++) {
                if (line.contains(args[i])) {
                    lineList.add(line);
                }
            }
        }
        bufferedReader.close();
        for (String s : lineList) {
            System.out.println(s);
        }
    }
}
