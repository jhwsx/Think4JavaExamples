package io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author wangzhichao
 * @since 2021/7/24
 */
public class ChannelCopy {
    private static final int BSIZE = 1024;
    private static final String file = "ChannelData.txt";
    public static void main(String[] args) throws Exception {
        FileChannel in = new FileInputStream(file).getChannel();
        FileChannel out = new FileOutputStream("ChannelDataCopy.txt").getChannel();
        ByteBuffer buffer = ByteBuffer.allocate(BSIZE);
        // FileChannel 的 read 方法：将字节序列从此通道读入给定的缓冲区。 返回读取的字节数，可能为零，如果该通道已到达流的末尾，则返回 -1
        while(in.read(buffer) != -1) {
            // 反转此缓冲区。首先将限制设置为当前位置，然后将位置设置为 0。用于下一步的写操作
            // 它将限制设置为当前位置，然后将位置设置为 0。
            buffer.flip();
            out.write(buffer); // 这里不用指定有效长度，真方便啊。
            // 清除此缓冲区，对所有的内部指令重新安排，为下次读做准备
            // 它将限制设置为容量大小，将位置设置为 0。
            buffer.clear();
        }
        out.close();
        in.close();
    }
}
