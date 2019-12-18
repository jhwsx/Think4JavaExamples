package generics;

import java.util.ArrayList;

/**
 * @author wangzhichao
 * @since 2019/12/18
 */
public class ErasedTypeEquivalence {
    public static void main(String[] args) {
        Class c1 = new ArrayList<String>().getClass();
        Class c2 = new ArrayList<Integer>().getClass();
        System.out.println(c1 == c2);
    }
}

/**
 * 打印结果为：true
 */
