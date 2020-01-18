package arrays;

import java.util.Arrays;

/**
 * @author wangzhichao
 * @since 2020/01/18
 */
public class ArrayOptions {
    public static void main(String[] args) {
        // 对象数组：
        BerylliumSphere[] a; // 局部的未初始化的变量
        BerylliumSphere[] b = new BerylliumSphere[5];
        // 数组 b 中的引用自动被初始化为 null
        // 打印：b: [null, null, null, null, null]
        System.out.println("b: " + Arrays.toString(b));
        BerylliumSphere[] c = new BerylliumSphere[4];
        for (int i = 0; i < c.length; i++) {
            // 可以测试引用是否是 null
            if (c[i] == null) {
                c[i] = new BerylliumSphere();
            }
        }
        // Aggregate initialization:
        BerylliumSphere[] d = {new BerylliumSphere(),
                new BerylliumSphere(), new BerylliumSphere()};
        // Dynamic aggregate initialization:
        a = new BerylliumSphere[]{
                new BerylliumSphere(), new BerylliumSphere()
        };
        System.out.println("a.length = " + a.length);
        System.out.println("b.length = " + b.length);
        System.out.println("c.length = " + c.length);
        System.out.println("d.length = " + d.length);
        a = d;
        // a 指向了 d 所标志的对象数组
        System.out.println("a.length = " + a.length);

        // 基本类型数组：
        int[] e; // Null reference
        int[] f = new int[5];
        // 数组的元素会自动被初始化为 0
        System.out.println("f: " + Arrays.toString(f));
        int[] g = new int[4];
        for (int i = 0; i < g.length; i++) {
            g[i] = i * i;
        }
        int[] h = {11, 47, 93};
        // 编译报错：因为 e 是局部变量，没有初始化不行。
        // System.out.println("e.length = " + e.length);
        System.out.println("f.length = " + f.length);
        System.out.println("g.length = " + g.length);
        System.out.println("h.length = " + h.length);
        e = h;
        System.out.println("e.length = " + e.length);
        e = new int[]{1, 2};
        System.out.println("e.length = " + e.length);

        char[] l = new char[5];
        // char 数组默认初始化为 0 对应的 char
        System.out.println("l: " + Arrays.toString(l));
        System.out.println(l[0] == (char) 0);
    }
}
