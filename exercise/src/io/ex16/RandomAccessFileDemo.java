package io.ex16;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Arrays;

/**
 * @author wangzhichao
 * @since 2021/7/18
 */
public class RandomAccessFileDemo {
    static String file = "raf.demo";
    public static void main(String[] args) throws IOException {
        RandomAccessFile raf = new RandomAccessFile(file, "rw");
        raf.write(new byte[]{1, 2, 3});
        raf.write(100);
        raf.writeBoolean(true);
        raf.writeByte(1);
        raf.writeBytes("hi");
        raf.writeChar('中');
        raf.writeChars("中国");
        raf.writeDouble(3.14159);
        raf.writeFloat(2.1f);
        raf.writeInt(2000);
        raf.writeLong(1000000);
        raf.writeShort(20);
        raf.writeUTF("WORLD");
        raf.close();

        display();

        raf = new RandomAccessFile(file, "rw");
        raf.seek(3);
        raf.write(111);
        raf.close();

        display();
    }

    private static void display() throws IOException {
        RandomAccessFile raf = new RandomAccessFile(file, "r");
        byte[] bytes = new byte[3];
        raf.read(bytes);
        System.out.println(Arrays.toString(bytes));
        System.out.println(raf.read());
        System.out.println(raf.readBoolean());
        System.out.println(raf.readByte());
        System.out.println((char) raf.readByte());
        System.out.println((char) raf.readByte());
        System.out.println(raf.readChar());
        System.out.println(raf.readChar());
        System.out.println(raf.readChar());
        System.out.println(raf.readDouble());
        System.out.println(raf.readFloat());
        System.out.println(raf.readInt());
        System.out.println(raf.readLong());
        System.out.println(raf.readShort());
        System.out.println(raf.readUTF());
        raf.close();
    }
}
