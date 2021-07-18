//: net/net.net.mindview/util/ProcessFiles.java
package net.mindview.util;

import java.io.*;

public class ProcessFiles {
    public interface Strategy {
        void process(File file);
    }

    /**
     * 策略对象
     */
    private final Strategy strategy;
    /**
     * 扩展名
     */
    private final String ext;

    public ProcessFiles(Strategy strategy, String ext) {
        this.strategy = strategy;
        this.ext = ext;
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
                        // Allow user to leave off extension:
                        if (!arg.endsWith("." + ext))
                            arg += "." + ext;
                        strategy.process(
                                new File(arg).getCanonicalFile());
                    }
                }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void
    processDirectoryTree(File root) throws IOException {
        for (File file : Directory.walk(
                root.getAbsolutePath(), ".*\\." + ext))
            strategy.process(file.getCanonicalFile());
    }

    // Demonstration of how to use it:
    public static void main(String[] args) {
        new ProcessFiles(new Strategy() {
            public void process(File file) {
                System.out.println(file);
            }
        }, "java").start(args);
    }
} /* (Execute to see output) *///:~
