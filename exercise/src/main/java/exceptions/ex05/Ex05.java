package exceptions.ex05;

import java.util.Arrays;

/**
 * <pre>
 *     author : wangzhichao
 *     e-mail : wangzhichao@adups.com
 *     time   : 2019/08/21
 *     desc   :
 *     version: 1.0
 * </pre>
 */
public class Ex05 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        int index = 5;
        while (true) {
            try {
                arr[index] = 5;
                break;
            } catch (Exception e) {
                e.printStackTrace();
            }
            index--;
        }
        System.out.println(Arrays.toString(arr));
    }
}
