package typeinfo.ex08;

import java.util.ArrayList;
import java.util.regex.Pattern;

/**
 * @author wangzhichao
 * @date 2019/11/02
 */
public class Ex08 {
    public static void main(String[] args) {
        printInfo("a");
        printInfo(new Integer(1));
        printInfo(new StackOverflowError());
        printInfo(new ArrayList<>());
        printInfo(new StringBuilder());
    }

    public static void printInfo(Object obj) {
        Class<?> clazz = obj.getClass();
        printInfo(clazz);
    }
    public static void printInfo(Class clazz) {
        if (clazz.getSimpleName().equals("Object")) {
            return;
        }
        System.out.println("Class name: " + clazz.getCanonicalName());
        Class superclass = clazz.getSuperclass();
        printInfo(superclass);
    }
}
