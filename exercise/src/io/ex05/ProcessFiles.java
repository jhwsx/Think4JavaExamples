//: net/net.net.mindview/util/ProcessFiles.java
package io.ex05;

import net.mindview.util.Directory;

import java.io.*;

/**
 * 修改ProcessFiles.java, 使其匹配正则表达式而不是固定的扩展名。
 *
 * @author wangzhichao
 * @since 2021/7/16
 */
public class ProcessFiles {
    public interface Strategy {
        void process(File file);
    }

    /**
     * 策略对象
     */
    private final Strategy strategy;
    /**
     * 正则表达式
     */
    private final String regex;

    public ProcessFiles(Strategy strategy, String regex) {
        this.strategy = strategy;
        this.regex = regex;
    }

    public void start(String[] args) {
        try {
            if (args.length == 0)
                // 没有提供任何参数，则遍历当前目录下的所有目录。
                processDirectoryTree(new File("."));
            else
                for (String arg : args) {
                    File fileArg = new File(arg);
                    if (fileArg.isDirectory())
                        // 是目录，通过 processDirectoryTree 方法来处理
                        processDirectoryTree(fileArg);
                    else {
                        // 是文件，直接使用策略对象来处理
                        if (arg.matches(regex)) {
                            strategy.process(
                                    new File(arg).getCanonicalFile());
                        }
                    }
                }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void
    processDirectoryTree(File root) throws IOException {
        for (File file : Directory.walk(
                root.getAbsolutePath(), regex))
            strategy.process(file.getCanonicalFile());
    }

    // Demonstration of how to use it:
    public static void main(String[] args) {
        new ProcessFiles(new Strategy() {
            public void process(File file) {
                System.out.println(file);
            }
        }, "C.*").start(args);
    }
} /* (Execute to see output) *///:~
