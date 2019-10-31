package strings.ex13;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author wangzhichao
 * @date 2019/10/17
 */
public class StartEnd {
    public static final String POEM =
            "Twas brillig, and the slithy toves\n" +
                    "Did gyre and gimble in the wabe.\n" +
                    "All mimsy were the borogoves,\n" +
                    "And the mome raths outgrabe.\n\n" +
                    "Beware the Jabberwock, my son,\n" +
                    "The jaws that bite, the claws that catch.\n" +
                    "Beware the Jubjub bird, and shun\n" +
                    "The frumious Bandersnatch.";

    private static class Display {
        private boolean regexPrinted = false;
        private String regex;

        Display(String regex) {
            this.regex = regex;
        }

        void display(String message) {
            if (!regexPrinted) {
                System.out.println(regex);
                regexPrinted = true;
            }
            System.out.println(message);
        }
    }

    static void examine(String s, String regex) {
        Display d = new Display(regex);
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(s);
        while (m.find()) {
            d.display("find() '" + m.group() +
                    "' start = " + m.start() + " end = " + m.end());
        }
        if (m.lookingAt()) { // 只有在正则表达式与输入的最开始处就开始匹配时才会成功。只要输入的第一部分匹配时就会成功。
            d.display("lookingAt() start = " +
                    m.start() + " end = " + m.end());
        }
        if (m.matches()) { // 只有在正则表达式与输入的最开始处就开始匹配时才会成功。只有在整个输入都匹配正则表达式时才会成功。
            d.display("matches() start = " +
                    m.start() + " end = " + m.end());
        }
    }

    public static void main(String[] args) {
        for (String in : POEM.split("\n")) {
            System.out.println("input: " + in);
            for (String regex : new String[]{
                    "\\w*ere\\w*", // \\w* 表示零个或者多个词字符
                    "m\\w*m\\w*", //
                    "T\\w+", // \\w+ 表示一个或者多个词字符
                    "The.*?" // .*? 表示零个多个任意字符，这是勉强型，最小匹配型
            }) {
                System.out.println("--------------------------examine " + regex + " start---------------------------");
                examine(in, regex);
                System.out.println("--------------------------examine " + regex + " end---------------------------");
            }
        }
    }
}
