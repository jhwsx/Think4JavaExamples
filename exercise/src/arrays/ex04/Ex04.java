package arrays.ex04;

import java.util.Arrays;

import arrays.ex03.Ex03;

/**
 * @author wangzhichao
 * @since 2020/01/19
 */
public class Ex04 {
    static double[][][] createArray(int size1, int size2, int size3, double start, double end) {
        if (!(start < end)) {
            System.out.println("Start must be less than end");
            return null;
        }
        if (size1 < 1 || size2 < 1 || size3< 1) {
            System.out.println("Size must be > 0");
            return null;
        }
        double[][][] result = new double[size1][size2][size3];
        for (int i = 0; i < size1; i++) {
            result[i] = Ex03.createArray(size2, size3, start, end);
        }
        return result;
    }

    static void printArray(double[][][] da) {
        System.out.println(Arrays.deepToString(da));
    }

    public static void main(String[] args) {
        printArray(createArray(0,2,3,4,5));
        printArray(createArray(2, 3, 3,5, 4));
        printArray(createArray(1,2,3,5,10));
    }
}