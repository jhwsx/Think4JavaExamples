package arrays;

import java.util.Arrays;
import java.util.Random;

/**
 * @author wangzhichao
 * @since 2020/01/19
 */
public class RaggedArray {
    public static void main(String[] args) {
        Random rand = new Random(47);
        // 创建了一个三维数组，仅仅指定了第一维的长度
        int i1 = rand.nextInt(7);
        System.out.println("i1 = " + i1);
        int[][][] a = new int[i1][][];
        for (int i = 0; i < a.length; i++) {
            // 指定第二维的长度
            int i2 = rand.nextInt(5);
            System.out.println("i2 = " + i2);
            a[i] = new int[i2][];
            for (int j = 0; j < a[i].length; j++) {
                // 指定第三维的长度
                int i3 = rand.nextInt(5);
                System.out.println("i3 = " + i3);
                a[i][j] = new int[i3];
            }
        }
        System.out.println(Arrays.deepToString(a));
    }
}
