package io.ex01;


import net.mindview.util.TextFile;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.Collections;
import java.util.regex.Pattern;

public class DirList {
    // 参数：T.*\.txt test1
    public static void main(String[] args) {
        File path = new File(".");
        final String[] list;
        if (args.length < 2) {
            list = path.list();
            System.out.println("Usage: enter filtering regex");
            System.out.println("followed by words, one or more of which each file must contain.");
        } else {
            list = path.list(new FilenameFilter() {
                private Pattern pattern = Pattern.compile(args[0]);
                @Override
                public boolean accept(File dir, String name) {
                    // 匹配文件名
                    return pattern.matcher(name).matches() &&
                            // 匹配文件内容
                            // 如果两个指定的集合没有共同的元素，则返回 true
                            !(Collections.disjoint(
                                    Arrays.asList(args).subList(1, args.length),
                                    new TextFile(name, "\\W+")
                            ));
                }
            });
        }
        Arrays.sort(list, String.CASE_INSENSITIVE_ORDER);
        for (String dirItem : list) {
            System.out.println(dirItem);
        }
    }
}
