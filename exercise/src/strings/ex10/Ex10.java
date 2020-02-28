package strings.ex10;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author wangzhichao
 * @date 2019/10/09
 */
public class Ex10 {
    public static void main(String[] args) {
        String[] regexes = {
                "^Java", // ^表示一行的开始
                "\\Breg.*", // \B 表示非词的边界, .表示任意字符，.* 表示零个或者多个任意字符
                "n.w\\s+h(a|i)s", // n 表示 n 字符，.表示任意字符，w 表示 w 字符，\s 表示空白符（这里是空格）\s+ 表示一个或者多个空白符，h 表示 h 字符，(a|i)表示捕获组，s表示 s字符
                "s?", // 一个或者零个 s
                "s*", // 零个或者多个 s
                "s+", // 一个或者多个 s
                "s{4}", // 恰好 4 个 s
                "s{1}", // 恰好 1 个 s
                "s{0,3}" // s 至少0 次，不超过 3 次
        };
        String input = "Java now has regular expressions";
        for (String regex : regexes) {
            System.out.println("Regular expression: " + regex);
            Pattern p = Pattern.compile(regex);
            Matcher m = p.matcher(input);
            while (m.find()) {
                System.out.println("Match \"" + m.group() + "\" at positions " +
                        m.start() + ((m.end() - m.start() < 2) ? "" :  ("-" + (m.end() - 1))));
            }
        }

    }

}
