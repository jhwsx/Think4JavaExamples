package strings;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author wangzhichao
 * @date 2019/10/31
 */
public class ReFlags {
    public static void main(String[] args) {
        Pattern pattern = Pattern.compile("^java", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE); // ^ 是边界匹配符，表示一行的起始
        Matcher m = pattern.matcher(
                "java has regex\nJava has regex\n" +
                        "JAVA has pretty good regular expression\n" +
                        "Regular expressions are in Java"
        );
        while (m.find()) {
            System.out.println(m.group() + ", start=" + m.start() + ", end=" + m.end());
        }
    }
}
