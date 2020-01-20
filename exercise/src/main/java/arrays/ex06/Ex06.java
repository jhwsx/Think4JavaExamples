package arrays.ex06;

import java.util.Arrays;

/**
 * @author wangzhichao
 * @since 2020/01/20
 */
/* Write a method that takes two int arguments, indicating the two sizes of
 * a 2-D array. The method should create and fill a 2-D array of BerylliumSphere
 * according to the size arguments.
 */


public class Ex06 {
    public static BerylliumSphere[][] createArray(int size1, int size2) {
        BerylliumSphere[][] result = new BerylliumSphere[size1][];
        for (int i = 0; i < result.length; i++) {
            result[i] = new BerylliumSphere[size2];
            for (int j = 0; j < result[i].length; j++) {
                result[i][j] = new BerylliumSphere();
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(createArray(3, 5)));
    }
}
