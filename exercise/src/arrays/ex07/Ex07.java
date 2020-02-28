package arrays.ex07;

import java.util.Arrays;

import arrays.ex06.BerylliumSphere;
import arrays.ex06.Ex06;

/**
 * @author wangzhichao
 * @since 2020/01/20
 */
// Repeat the previous exercise for a 3-D array.
public class Ex07 {
    static BerylliumSphere[][][] createArray(int size1, int size2, int size3) {
        BerylliumSphere[][][] result = new BerylliumSphere[size1][][];
        for (int i = 0; i < result.length; i++) {
            result[i] = Ex06.createArray(size2, size3);
        }
        return result;
    }
    public static void main(String[] args) {
        BerylliumSphere[][][] array = createArray(2, 3, 4);
        System.out.println(Arrays.deepToString(array));
    }
}
