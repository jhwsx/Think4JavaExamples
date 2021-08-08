package io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.channels.FileChannel;

/**
 * 优化 {@link ChannelCopy}
 *
 * 使用特殊方法 transferTo() 和 transferFrom() 将一个通道和另一个通道直接相连
 *
 * @author wangzhichao
 * @since 2021/7/24
 */
public class TransferTo {
    private static final String file = "ChannelData.txt";
    public static void main(String[] args) throws Exception {
        FileChannel in = new FileInputStream(file).getChannel();
        FileChannel out = new FileOutputStream("ChannelDataCopy2.txt").getChannel();
        // 这种 api 太 6 了。
//        in.transferTo(0, in.size(), out);
        // Or:
        out.transferFrom(in, 0, in.size());
        in.close();
        out.close();
    }
}
