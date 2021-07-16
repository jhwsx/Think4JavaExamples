package io.ex02;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 创建一个叫做SortedDirList的类，它具有一个可以接受文件路径信息，并能构建该路径下
 * 所有文件的排序目录列表的构造器。向这个类添加两个重载的list()方法：一个产生整个列表，
 * 另一个产生与其参数（一个正则表达式）相匹配的列表的子集
 *
 * @author wangzhichao
 * @since 2021/7/16
 */
public class SortedDirList {
    private final File dir;
    private final String[] list;
    public SortedDirList(String dirPath) {
        dir = new File(dirPath);
        if (!dir.isDirectory()) {
            throw new IllegalArgumentException("please input a dir path");
        }
        String[] list = dir.list();
        Arrays.sort(list, String.CASE_INSENSITIVE_ORDER);
        this.list = list;
    }

    public String[] list() {
        return list;
    }

    public String[] list(String regex) {
        Pattern pattern = Pattern.compile(regex);
        return dir.list(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                Matcher matcher = pattern.matcher(name);
                return matcher.matches();
            }
        });
    }

    public static void main(String[] args) {
        SortedDirList sortedDirList = new SortedDirList(".");
        String[] list = sortedDirList.list();
        System.out.println(Arrays.toString(list));
        String[] list1 = sortedDirList.list("T.*\\.txt");
        System.out.println(Arrays.toString(list1));
    }
}
