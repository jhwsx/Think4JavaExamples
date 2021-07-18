package io.ex13;

import java.io.*;

/**
 * 修改 BasicFileOutput.java，以便可以使用LineNumberReader 来记录行数。注意继续使用编程方式实现跟踪会更简单。
 *
 * @author wangzhichao
 * @since 2021/7/18
 */
public class Ex13 {
    static String file = "Ex13.out";

    public static void main(String[] args) throws IOException {
        LineNumberReader in = new LineNumberReader(
                new StringReader(BufferedInputFile.read("D:\\Android\\Workspace\\github\\Think4JavaExamples\\exercise\\src\\io\\ex13\\Ex13.java"))
        );

        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(file)));

        String line;
        while ((line = in.readLine()) != null) {
            out.println(in.getLineNumber() + ":" + line);
        }

        out.close();
        in.close();

        String read = BufferedInputFile.read(file);
        System.out.println(read);
    }

}
