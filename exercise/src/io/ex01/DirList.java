package io.ex01;

import net.mindview.util.TextFile;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.Collections;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DirList {
    // 参数：D.*\.java
    public static void main(String[] args) {
        String regex = ".*\\.java";
        // 文件目录
        File path = new File(".");
        // 是否指定了正则表达式
        String[] list;
//        if (args.length == 0) {
//            list = path.list();
//        } else {
            list = path.list(new DirFilter(regex));
//        }
        // 忽略大小排序
        Arrays.sort(list, String.CASE_INSENSITIVE_ORDER);
        // 打印
        for (String dirItem : list) {
            System.out.println(dirItem);
        }
    }

}

class DirFilter implements FilenameFilter {

    private Pattern pattern;
    private String regex;
    public DirFilter(String regex) {
        // 将给定的正则表达式编译到模式中。
        pattern = Pattern.compile(regex);
        this.regex = regex;
    }

    @Override
    public boolean accept(File dir, String name) {
        Collections.disjoint(Arrays.asList(regex).subList(1, regex.length()),
                new TextFile(name, "\\W+"));
        // 创建匹配器
        Matcher matcher = pattern.matcher(name);
        // 尝试将整个区域与模式匹配
        return matcher.matches();
    }
}
