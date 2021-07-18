package io.ex12;

import java.io.*;
import java.util.Collections;
import java.util.LinkedList;

/**
 * 修改练习8，同样也打开一个文本文件，以便将文本写入其中。将 LinkedList 中的各行随同行号一起写入文件（不要试图使用LineNumber类）。
 *
 * @author wangzhichao
 * @since 2021/7/17
 */
public class Ex12 {
    static final String file = "Ex12.out";
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
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
        int lineCount = 1;
        for (String s : lineList) {
            bufferedWriter.write(lineCount++ + ":"+s);
            bufferedWriter.newLine();
        }
        bufferedWriter.close();
    }
}
