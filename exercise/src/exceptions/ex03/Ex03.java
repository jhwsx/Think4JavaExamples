package exceptions.ex03;

/**
 * <pre>
 *     author : wangzhichao
 *     e-mail : wangzhichao@adups.com
 *     time   : 2019/08/21
 *     desc   :
 *     version: 1.0
 * </pre>
 */
public class Ex03 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3};

        try {
            arr[4] = 5;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
