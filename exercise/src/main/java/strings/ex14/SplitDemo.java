package strings.ex14;

import java.util.Arrays;
import java.util.regex.Pattern;

/**
 * Pattern.split() 方法演示
 * @author wangzhichao
 * @date 2019/10/31
 */
public class SplitDemo {
    public static void main(String[] args) {
        String input = "This!!unusual use!!of exclamation!!points";
        System.out.println("method1:");
        System.out.println(Arrays.toString(Pattern.compile("!!").split(input)));
        System.out.println(Arrays.toString(Pattern.compile("!!").split(input,3)));
        System.out.println("method2");
        System.out.println(Arrays.toString(input.split("!!")));
        System.out.println(Arrays.toString(input.split("!!", 3)));
    }
}