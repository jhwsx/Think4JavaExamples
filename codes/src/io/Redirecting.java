package io;

import java.io.*;

/**
 * 标准 I/O 重定向
 *
 * 注意：重定向操作的都是字节流，而不是字符流。
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
        System.setIn(in); // 对标准输入流进行重定向
        System.setOut(out); // 对标准输出流进行重定向
        System.setErr(out); // 对标准错误流进行重定向

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
