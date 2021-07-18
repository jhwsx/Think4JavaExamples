package io.ex20;

import net.mindview.util.BinaryFile;
import net.mindview.util.Directory;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

/**
 * 用 Directory.walk() 和 BinaryFile 来验证在某个目录树下的所有的 .class 文件都是以十六进制 “CAFEBABE” 开头的。
 *
 * @author wangzhichao
 * @since 2021/7/18
 */
public class Ex20 {
    public static void main(String[] args) throws IOException {
        Directory.TreeInfo treeInfo = Directory.walk(".", ".*\\.class");
        for (File file : treeInfo) {
//            System.out.println(file.getAbsolutePath());
            byte[] bytes = BinaryFile.read(file);
            byte[] bytes1 = "CAFEBABE".getBytes();
            byte[] test = new byte[bytes1.length];
            System.arraycopy(bytes1, 0, test, 0, bytes1.length);
            // 比较 test 与 bytes1 的内容是不是一模一样的
            if (!Arrays.equals(test, bytes1)) {
                System.err.println("wtf");
            }
        }
    }
}
