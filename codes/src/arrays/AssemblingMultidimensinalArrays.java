package arrays;

import java.util.Arrays;

/**
 * @author wangzhichao
 * @since 2020/01/19
 */
public class AssemblingMultidimensinalArrays {
    public static void main(String[] args) {
        Integer[][] a;
        a = new Integer[3][];
        for (int i = 0; i < a.length; i++) {
            a[i] = new Integer[3];
            for (int j = 0; j < a[i].length; j++) {
                // 自动装箱
                a[i][j] = i * j;
            }
        }
        System.out.println(Arrays.deepToString(a));
    }
}
