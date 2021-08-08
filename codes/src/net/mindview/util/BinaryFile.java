//: net/net.net.mindview/util/BinaryFile.java
// Utility for reading files in binary form.
package net.mindview.util;

import java.io.*;

/**
 * 读取二进制文件
 */
public class BinaryFile {
    public static byte[] read(File bFile) throws IOException {
        BufferedInputStream bf = new BufferedInputStream(
                new FileInputStream(bFile));
        try {
            // 使用 available() 方法来产生恰当的数组尺寸。厉害啊
            // 文件如果太大，不要用这种方法来写。
            byte[] data = new byte[bf.available()];
            bf.read(data);
            return data;
        } finally {
            bf.close();
        }
    }

    public static byte[]
    read(String bFile) throws IOException {
        return read(new File(bFile).getAbsoluteFile());
    }
} ///:~
