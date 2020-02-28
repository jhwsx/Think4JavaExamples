package strings.ex08;

import java.util.Arrays;

/**
 * @author wangzhichao
 * @date 2019/09/21
 */
public class Ex08 {
    public static String knights =
            "Then, when you have found the shrubbery, you must " +
                    "cut down the mightiest tree in the forest... " +
                    "with... a herring!";

    public static void main(String[] args) {
        System.out.println(Arrays.toString(knights.split("the|you")));
    }
}
