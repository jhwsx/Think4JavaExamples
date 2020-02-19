package arrays.ex20;

import java.util.Arrays;

/**
 * @author wzc
 * @date 2020/2/6
 */
public class Ex20 {
    public static void main(String[] args) {
        int[][] a1 = {{1, 2, 3}, {4, 5, 6}};
        int[][] a2 = {{1, 2, 3}, {4, 5, 6}};
        System.out.println(Arrays.deepEquals(a1, a2));
        String[][][] a3 = new String[2][2][2];
        String[][][] a4 = new String[2][2][2];
        System.out.println(Arrays.deepEquals(a3, a4));
    }
}
