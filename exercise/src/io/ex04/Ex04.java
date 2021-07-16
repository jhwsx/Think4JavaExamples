package io.ex04;

import net.mindview.util.Directory;

import java.io.File;

/**
 * 使用 Directory.walk() 来计算在目录中所有名字与特定的正则表达式相匹配的文件的尺寸总和
 *
 * @author wangzhichao
 * @since 2021/7/16
 */
public class Ex04 {
    public static void main(String[] args) {
        Directory.TreeInfo treeInfo = Directory.walk(new File("."), "T.*\\.java");
        long totalSize = 0L;
        for (File file : treeInfo) {
            totalSize += file.length();
        }
        System.out.println("Total size: " + totalSize);
    }
}
