package strings.ex11;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author wangzhichao
 * @date 2019/10/09
 */
public class Ex11 {
    public static void main(String[] args) {
        String regex = "(?i)((^[aeiou])|(\\s+[aeiou]))\\w+?[aeiou]\\b";
        String input = "Arline ate eight apples and one orange while Anita hadn't any";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(input);
        System.out.println(m.find());
    }
}
