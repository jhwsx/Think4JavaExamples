package io;

import java.io.*;

/**
 * 存储和恢复数据
 *
 * 为了输出可供另一个“流”恢复的数据，我们需要用 DataOutputStream 写入数据，并用 DataInputStream 恢复数据。
 *
 * @author wangzhichao
 * @since 2021/7/18
 */
public class StoringAndRecoveringData {
    static String file = "Data.txt";
    public static void main(String[] args) throws IOException {
        // 使用 DataOutputStream 写入数据
        DataOutputStream out = new DataOutputStream(
                new BufferedOutputStream(
                        new FileOutputStream(file)
                )
        );
        out.writeDouble(3.14159);
        out.writeUTF("That was pi");
        out.writeDouble(1.41413);
        out.writeUTF("Square root of 2");
        out.close();

        // 使用 DataInputStream 读取数据，恢复数据
        DataInputStream in = new DataInputStream(
                new BufferedInputStream(
                        new FileInputStream(file)
                )
        );
        System.out.println(in.readDouble());
        System.out.println(in.readUTF());
        System.out.println(in.readDouble());
        System.out.println(in.readUTF());
        in.close();
    }
}
