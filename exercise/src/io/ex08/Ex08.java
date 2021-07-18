package io.ex08;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collections;
import java.util.LinkedList;

/**
 * 修改练习7，使要读取的文件的名字以命令行参数的形式提供。
 *
 * @author wangzhichao
 * @since 2021/7/17
 */
public class Ex08 {
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
            lineList.add(line);
        }
        bufferedReader.close();
        Collections.reverse(lineList);
        for (String s : lineList) {
            System.out.println(s);
        }
    }
}
