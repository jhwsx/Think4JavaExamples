package io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * 演示三种类型的流（FileInputStream、FileOutputStream 以及 RandomAccessFile），
 * 用以产生可写的、可读可写的以及可读的通道
 *
 * @author wangzhichao
 * @since 2021/7/24
 */
public class GetChannel {
    private static final int BSIZE = 1024;
    private static final String file = "ChannelData.txt";
    public static void main(String[] args) throws Exception {
        // 写一个文件
        // FileOutputStream 的 getChannel 方法：返回与此文件输出流有关的唯一 FileChannel 对象
        FileChannel fc = new FileOutputStream(file).getChannel();
        // ByteBuffer 的静态 wrap 方法：将 byte 数组包装到缓冲区中
        // FileChannel 的 write 方法：将字节序列从给定的缓冲区写入此通道。
        fc.write(ByteBuffer.wrap("Some text ".getBytes()));
        // 关闭此通道
        fc.close();

        // 添加到文件的尾部
        // RandomAccessFile 的 getChannel 方法：返回与此文件关联的唯一 FileChannel 对象。
        fc = new RandomAccessFile(file, "rw").getChannel();
        // position 方法：设置此通道的文件位置
        // size 方法：返回此通道的文件的当前大小
        // 这行代码表示：移动到末尾
        fc.position(fc.size());
        fc.write(ByteBuffer.wrap("Some more 你好，世界".getBytes()));
        fc.close();

        // 读取文件
        // FileInputStream 的 getChannel 方法：返回与此文件输入流有关的唯一 FileChannel 对象。
        fc = new FileInputStream(file).getChannel();
        // 分配一个新的字节缓冲区。
        ByteBuffer buff = ByteBuffer.allocate(BSIZE);
        // 将字节序列从此通道读入给定的缓冲区。
        fc.read(buff);
        // 反转此缓冲区。首先将限制设置为当前位置，然后将位置设置为 0。
        buff.flip();
        // hasRemaining 方法：告知在当前位置和限制之间是否有元素。
        while (buff.hasRemaining()) {
            // 打印出的中文是乱码的，因为这里是把字节强转为字符的。
            System.out.print(((char) buff.get()));
        }
        fc.close();
    }
}
