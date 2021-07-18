package io;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.IOException;

/**
 * 格式化的内存输入
 *
 * @author wangzhichao
 * @since 2021/7/17
 */
public class FormattedMemoryInput {
    public static void main(String[] args) throws IOException {
        String s = BufferedInputFile.read("D:\\Android\\Workspace\\github\\Think4JavaExamples\\codes\\src\\io\\MemoryInput.java");
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(s.getBytes());
        DataInputStream dataInputStream = null;
        try {
            dataInputStream = new DataInputStream(byteArrayInputStream);
            while (true) {
                System.out.println(((char) dataInputStream.readByte()));
            }
        } catch (EOFException e) {
            System.err.println("End of stream");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (dataInputStream != null) {
                dataInputStream.close();
            }
        }
    }
}
