package io.ex06;

import net.mindview.util.ProcessFiles;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 使用 ProcessFiles 来查找在某个特定目录子树下的所有在某个特定日期之后进行过修改的Java源代码文件。
 *
 * 参数配置：. 03/01/2021
 * @author wangzhichao
 * @since 2021/7/16
 */
public class Ex06 {
    public static void main(String[] args) {
        if (args.length != 2) {
            System.err.println("Usage: fileDir MM/dd/yyyy");
            System.exit(1);
        }
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
        new ProcessFiles(new ProcessFiles.Strategy() {
            @Override
            public void process(File file) {
                Date modDate = new Date(file.lastModified());
                try {
                    if (modDate.after(sdf.parse(args[1]))) {
                        System.out.println(file);
                    }
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }
        }, "java").start(args);
    }
}
