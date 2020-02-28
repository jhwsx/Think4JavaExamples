package strings.ex07;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author wangzhichao
 * @date 2019/09/21
 */
public class Ex07 {
    public static void main(String[] args) {
        String regex = "^[A-Z].*[\\.]$";// [A-Z] 表示以大写字母开头，.* 表示0个或多个任意字符（.表示任意字符，X* 表示 X 零次或多次）
        String s1 = "How is it going.";
        System.out.println(s1.matches(regex));
        String s2 = "how is it going.";
        System.out.println(s2.matches(regex));
        String s3 = "How is it going?";
        System.out.println(s3.matches(regex));
        String s4 = "H.";
        System.out.println(s4.matches(regex));
    }
}
