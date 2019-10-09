package strings;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author wangzhichao
 * @date 2019/10/09
 */
public class TestRegularExpression {
    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("Usage:\njava TestRegularExpression " +
                    "characterSequence regularExpression+");
            System.exit(0);
        }
        System.out.println("Input: \"" + args[0] + "\""); // 要检索的字符串
        for (String arg : args) {
            System.out.println("Regular expression: \"" + arg + "\"");
            // 传入String类型的正则表达式，创建一个 Pattern 对象
            Pattern p = Pattern.compile(arg);
            // 把要检索的字符串传入 matcher 方法，会生成一个 Matcher 对象
            Matcher m = p.matcher(args[0]);
            while (m.find()) {
                System.out.println("Match \"" + m.group() + "\" at positions " +
                        m.start() + "-" + (m.end() - 1));
            }
        }

    }
}

/*
G:\AndroidWorkspaces\Think4JavaExamples\app\src\main\java>javac -encoding UTF-8 strings/TestRegularExpression.java

G:\AndroidWorkspaces\Think4JavaExamples\app\src\main\java>java strings/TestRegularExpression abcabcabcdefabc abc+ (abc)+ (abc){2,}
Input: "abcabcabcdefabc"
Regular expression: "abcabcabcdefabc"
Match "abcabcabcdefabc" at positions 0-14
Regular expression: "abc+"
Match "abc" at positions 0-2
Match "abc" at positions 3-5
Match "abc" at positions 6-8
Match "abc" at positions 12-14
Regular expression: "(abc)+"
Match "abcabcabc" at positions 0-8
Match "abc" at positions 12-14
Regular expression: "(abc){2,}"
Match "abcabcabc" at positions 0-8
 */
