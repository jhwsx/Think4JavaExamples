package io;

import java.io.*;

/**
 * 标准 I/O 重定向
 *
 * @author wangzhichao
 * @since 2021/7/18
 */
public class Redirecting {
    public static void main(String[] args) throws IOException {
        PrintStream console = System.out;
        BufferedInputStream in = new BufferedInputStream(new FileInputStream(
                "D:\\Android\\Workspace\\github\\Think4JavaExamples\\codes\\src\\io\\Redirecting.java"
        ));
        PrintStream out = new PrintStream(new BufferedOutputStream(new FileOutputStream("redirecting.out")));
        System.setIn(in);
        System.setOut(out);
        System.setErr(out);

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s;
        while((s = br.readLine()) != null) {
            System.out.println(s);
        }
        out.close(); // 不加这行，不行！！！
        br.close();
        System.setOut(console);
    }
}
