package io.ex15;

import java.io.*;
import java.util.Arrays;

/**
 * @author wangzhichao
 * @since 2021/7/18
 */
public class Ex15 {
    static String file = "Ex15.out";

    public static void main(String[] args) throws IOException {
        // 使用 DataOutputStream 写入数据
        DataOutputStream out = new DataOutputStream(
                new BufferedOutputStream(
                        new FileOutputStream(file)
                )
        );
        out.write(new byte[]{1, 2, 3}, 0, 3);
        out.write(100);
        out.writeBoolean(true);
        out.writeByte(1);
        out.writeBytes("hello");
        out.writeChar('中');
        out.writeChars("中国");
        out.writeDouble(1.2345);
        out.writeFloat(2.1f);
        out.writeInt(1000);
        out.writeLong(2000000);
        out.writeShort(20);
        out.writeUTF("world");
        out.close();

        // 使用 DataInputStream 读取数据
        DataInputStream in = new DataInputStream(
                new BufferedInputStream(
                        new FileInputStream(file)
                )
        );
        byte[] bytes = new byte[3];
        in.read(bytes, 0, 3);
        System.out.println(Arrays.toString(bytes));
        System.out.println(in.read());
        System.out.println(in.readBoolean());
        System.out.println(in.readByte());
        System.out.println((char) in.read());
        System.out.println((char) in.read());
        System.out.println((char) in.read());
        System.out.println((char) in.read());
        System.out.println((char) in.read());
        System.out.println(in.readChar());
        System.out.println(in.readChar());
        System.out.println(in.readChar());
        System.out.println(in.readDouble());
        System.out.println(in.readFloat());
        System.out.println(in.readInt());
        System.out.println(in.readLong());
        System.out.println(in.readShort());
        System.out.println(in.readUTF());
        in.close();
    }
}
