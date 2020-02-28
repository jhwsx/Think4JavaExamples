package arrays.ex02;

import java.util.Arrays;

/**
 * @author wangzhichao
 * @since 2020/01/19
 */
/*
// Write a method that takes an int argument and returns an
// array of that size filled BerylliumSpheres.
*/
class BerylliumSphere {
    private static long counter;
    private final long id = counter++;

    @Override
    public String toString() {
        return "Sphere " + id;
    }
}

public class Ex02 {
    static BerylliumSphere[] newArray(int length) {
        BerylliumSphere[] result = new BerylliumSphere[length];
        for (int i = 0; i < result.length; i++) {
            result[i] = new BerylliumSphere();
        }
        return result;
    }
    public static void main(String[] args) {
        System.out.println(Arrays.toString(newArray(5)));
        System.out.println(Arrays.toString(newArray(2)));
        System.out.println(Arrays.toString(newArray(0)));
//        System.out.println(Arrays.toString(newArray(-5)));
    }
}
