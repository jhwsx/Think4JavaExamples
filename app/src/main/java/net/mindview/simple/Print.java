package net.mindview.simple;

import java.io.PrintStream;

/**
 * @author wzc
 * @date 2019/6/14
 */
public class Print {
    public static void print(Object object) {
        System.out.println(object);
    }
    public static void print() {
        System.out.println();
    }

    public static void printnb(Object object) {
        System.out.print(object);
    }

    public static PrintStream printf(String format, Object... args) {
        return System.out.printf(format, args);
    }
}
