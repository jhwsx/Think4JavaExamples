package io;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DirList2 {
    // 返回FilenameFilter 的匿名内部类的写法
    public static FilenameFilter filter(final String regex) {
        return new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                Pattern pattern = Pattern.compile(regex);
                Matcher matcher = pattern.matcher(name);
                return matcher.matches();
            }
        };
    }

    public static void main(String[] args) {
        // 文件目录
        File path = new File(".");
        // 是否指定了正则表达式
        String[] list;
        if (args.length == 0) {
            list = path.list();
        } else {
            list = path.list(filter(args[0]));
        }
        // 忽略大小写排序
        Arrays.sort(list, String.CASE_INSENSITIVE_ORDER);
        // 打印
        for (String dirItem : list) {
            System.out.println(dirItem);
        }
    }
}
