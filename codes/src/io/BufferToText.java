package io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;

/**
 * @author wangzhichao
 * @since 2021/7/24
 */
public class BufferToText {
    private static final int BSIZE = 1024;
    public static final String file = "BufferToText.txt";
    public static final String file2 = "BufferToText2.txt";
    public static final String file3 = "BufferToText3.txt";
    public static void main(String[] args) throws Exception {
        FileChannel fc = new FileOutputStream(file).getChannel();
        fc.write(ByteBuffer.wrap("好好学习，天天向上".getBytes()));
        fc.close();
        fc = new FileInputStream(file).getChannel();
        ByteBuffer buff = ByteBuffer.allocate(BSIZE);
        // 将字节序列从此通道读入给定的缓冲区。
        fc.read(buff);
        buff.flip();
        // 不能输出 "好好学习，天天向上"
        System.out.println(buff.asCharBuffer().toString());

        // 使用系统默认的字符集来进行解码
        // 重绕此缓冲区。将位置设置为 0 并丢弃标记。它使限制保持不变，将位置设置为 0。
        buff.rewind();
        String encoding = System.getProperty("file.encoding");
        // 输出：Decode using UTF-8: 好好学习，天天向上
        System.out.println("Decode using " + encoding + ": " + Charset.forName(encoding).decode(buff));

        // 或者，使用某个可以打印的字符集来进行编码
        fc = new FileOutputStream(file2).getChannel();
        // UTF-16BE，其后缀是 BE 即 big-endian，大端的意思。大端就是将高位的字节放在低地址表示。
        fc.write(ByteBuffer.wrap("好好学习，天天向上".getBytes("UTF-16BE")));
        fc.close();
        fc = new FileInputStream(file2).getChannel();
        buff.clear();
        // 将字节序列从此通道读入给定的缓冲区。
        fc.read(buff);
        buff.flip();
        System.out.println(buff.asCharBuffer().toString()); // 输出：好好学习，天天向上
        fc.close();

        // 使用 CharBuffer 来写
        fc = new FileOutputStream(file3).getChannel();
        buff = ByteBuffer.allocate(256);
        buff.asCharBuffer().put("好好学习，天天向上");
        fc.write(buff);
        fc.close();
        fc = new FileInputStream(file3).getChannel();
        buff.clear();
        // 将字节序列从此通道读入给定的缓冲区。
        int length = fc.read(buff);
        buff.flip();
        CharBuffer charBuffer = buff.asCharBuffer();
        char[] chars = charBuffer.toString().toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '\u0000') {
                // 读到第一个为默认 char 值的索引就跳出循环。
                break;
            }
            sb.append(chars[i]);
        }
        System.out.println(sb); // 输出：好好学习，天天向上
        fc.close();
    }
}
