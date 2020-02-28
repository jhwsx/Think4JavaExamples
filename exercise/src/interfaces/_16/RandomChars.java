package interfaces._16;

import java.util.Random;

/**
 * <pre>
 *     author : wangzhichao
 *     e-mail : wangzhichao@adups.com
 *     time   : 2019/07/20
 *     desc   :
 *     version: 1.0
 * </pre>
 */
public class RandomChars {
    private static Random random = new Random();
    public char next() {
        return (char) random.nextInt(128);
    }

    public static void main(String[] args) {
        RandomChars randomChars = new RandomChars();
        for (int i = 0; i < 20; i++) {
            System.out.print(randomChars.next() + " ");
        }
    }
}
