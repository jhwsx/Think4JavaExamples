package io;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DirList {
    // 参数：D.*\.java
    // T.*\.txt 以 T 开头并且以 .txt 结尾的文件
    public static void main(String[] args) {
        // 文件目录
        File path = new File(".");
        // 是否指定了正则表达式
        String[] list;
        if (args.length == 0) {
            list = path.list();
        } else {
            list = path.list(new DirFilter(args[0]));
        }
        // 忽略大小写排序
        Arrays.sort(list, String.CASE_INSENSITIVE_ORDER);
        // 打印
        for (String dirItem : list) {
            System.out.println(dirItem);
        }
    }

}

class DirFilter implements FilenameFilter {

    private Pattern pattern;

    public DirFilter(String regex) {
        // 将给定的正则表达式编译到模式中。
        pattern = Pattern.compile(regex);
    }

    @Override
    public boolean accept(File dir, String name) {
        // 创建匹配器
        Matcher matcher = pattern.matcher(name);
        // 尝试将整个区域与模式匹配
        return matcher.matches();
    }
}
