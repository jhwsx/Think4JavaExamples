package typeinfo.ex09;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author wangzhichao
 * @date 2019/11/02
 */
public class Ex09 {
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
        System.out.println("Class.getDeclaredFields: " + Arrays.toString(clazz.getDeclaredFields()));
        Class superclass = clazz.getSuperclass();
        printInfo(superclass);
    }
}
