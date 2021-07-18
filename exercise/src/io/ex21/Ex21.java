package io.ex21;

import java.io.*;

/**
 * @author wangzhichao
 * @since 2021/7/18
 */
public class Ex21 {
    public static void main(String[] args) throws IOException {
        File file = new File("D:\\Android\\Workspace\\github\\Think4JavaExamples\\exercise\\src\\io\\ex21\\Ex21.java");
        BufferedInputStream inFile =
                new BufferedInputStream(
                        new FileInputStream(file)
                );
        // 重新分配“标准”输入流
        System.setIn(inFile);
        BufferedReader stdin = new BufferedReader(
            new InputStreamReader(System.in)
        );

        String s;
        while((s = stdin.readLine()) != null) {
            System.out.println(s.toUpperCase());
        }
    }
}
