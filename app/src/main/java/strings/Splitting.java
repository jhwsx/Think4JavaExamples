package strings;

import java.util.Arrays;

/**
 * @author wangzhichao
 * @date 2019/09/20
 */
public class Splitting {
    public static String knights =
            "Then, when you have found the shrubbery, you must " +
                    "cut down the mightiest tree in the forest... " +
                    "with... a herring!";

    public static void split(String regex) {
        System.out.println(Arrays.toString(knights.split(regex)));
    }
    public static void main(String[] args) {
        split(" ");
        split("\\W+"); // \W 表示非单词字符，前面再加一个\是转义的意思；+表示一次或多次
        split("n\\W+"); // 字母n后面跟着一个或多个非单词字符
    }
}
