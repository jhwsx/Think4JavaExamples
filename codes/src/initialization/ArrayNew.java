package initialization;

import java.util.Arrays;
import java.util.Random;

/**
 * @author wzc
 * @date 2019/6/10
 */
public class ArrayNew {
    public static void main(String[] args) {
        char[] a;
        Random rand = new Random(47);
        a = new char[rand.nextInt(20)];
        System.out.println("length of a = " + a.length);
        System.out.println(Arrays.toString(a));
    }
}
