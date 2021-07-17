package io;

import java.io.*;

/**
 * @author wangzhichao
 * @since 2021/7/17
 */
public class BasicFileOutput {
    static String file = "BasicFileOutput.out";
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(
                new StringReader(BufferedInputFile.read("D:\\Android\\Workspace\\github\\Think4JavaExamples\\codes\\src\\io\\BasicFileOutput.java"))
        );
        PrintWriter out = new PrintWriter(
                new BufferedWriter(
                        new FileWriter(file)
                )
        );
        String line;
        int lineCount = 1;
        while((line = in.readLine()) != null) {
            out.println(lineCount++ + ":" + line);
        }
        out.close();
        in.close();

        String read = BufferedInputFile.read(file);
        System.out.println(read);
    }

}
