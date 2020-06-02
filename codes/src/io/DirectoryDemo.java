package io;

import net.mindview.util.Directory;
import net.mindview.util.PPrint;

import java.io.File;

import static net.mindview.util.Print.print;

public class DirectoryDemo {
    public static void main(String[] args) {
        // 所有目录
        PPrint.pprint(Directory.walk("./codes/src/access").dirs);
        // 所有以 C 开头的文件
        File[] files = Directory.local("./codes/src/access", "C.*");
        for (File file : files) {
            print(file);
        }
        print("---------------------");
        // 所有以 C 开头的 java 文件
        Directory.TreeInfo treeInfo = Directory.walk(".", "C.*\\.java"); // .* 0 个或多个任意字符；\\. 表示一个 ., 进行了转义处理
        for (File file : treeInfo) {
            print(file);
        }
        print("=====================");
        // 所有包含 Z 或者 z 的 文件
        Directory.TreeInfo treeInfo1 = Directory.walk(".", ".*[Zz].*\\.class");
        for (File file : treeInfo1) {
            print(file);
        }
    }
}
