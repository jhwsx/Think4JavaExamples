package arrays.ex05;

import java.util.Arrays;

/**
 * @author wangzhichao
 * @since 2020/01/20
 */
// Demonstrate that multidimensional arrays of non-primitives are
// automatically initialized to null.
class A {
}

public class Ex05 {
    public static void main(String[] args) {
        A[][][] a = new A[2][2][3];
        System.out.println(Arrays.deepToString(a));
    }
}
