package arrays;

import java.util.Arrays;

/**
 * 学习 Arrays.fill() 方法: 使用单一的值来填充整个数组或者数组的某个区域。
 * @author wzc
 * @date 2020/1/30
 */
public class FillingArrays {
    public static void main(String[] args) {
        int size = 6;
        boolean[] a1 = new boolean[size];
        byte[] a2 = new byte[size];
        char[] a3 = new char[size];
        short[] a4 = new short[size];
        int[] a5 = new int[size];
        long[] a6 = new long[size];
        float[] a7 = new float[size];
        double[] a8 = new double[size];
        String[] a9 = new String[size];
        // 填充整个数组
        Arrays.fill(a1, true);
        System.out.println("Arrays.toString(a1) = " + Arrays.toString(a1));
        Arrays.fill(a2, (byte) 11);
        System.out.println("Arrays.toString(a2) = " + Arrays.toString(a2));
        Arrays.fill(a3, 'x');
        System.out.println("Arrays.toString(a3) = " + Arrays.toString(a3));
        Arrays.fill(a4, (short) 100);
        System.out.println("Arrays.toString(a4) = " + Arrays.toString(a4));
        Arrays.fill(a5, 1000);
        System.out.println("Arrays.toString(a5) = " + Arrays.toString(a5));
        Arrays.fill(a6, 1L);
        System.out.println("Arrays.toString(a6) = " + Arrays.toString(a6));
        Arrays.fill(a7, 2.1f);
        System.out.println("Arrays.toString(a7) = " + Arrays.toString(a7));
        Arrays.fill(a8, 2.2d);
        System.out.println("Arrays.toString(a8) = " + Arrays.toString(a8));
        Arrays.fill(a9, "Hello");
        System.out.println("Arrays.toString(a9) = " + Arrays.toString(a9));
        // 填充数组的某个区域
        Arrays.fill(a9, 3, 5, "World");
        System.out.println("Arrays.toString(a9) = " + Arrays.toString(a9));
    }
}
