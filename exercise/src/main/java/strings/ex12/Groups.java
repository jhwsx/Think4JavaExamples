package strings.ex12;

import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author wangzhichao
 * @date 2019/10/09
 */
public class Groups {
    public static final String POEM =
            "Twas brillig, and the slithy toves\n" +
                    "Did gyre and gimble in the wabe.\n" +
                    "All mimsy were the borogoves,\n" +
                    "And the mome raths outgrabe.\n\n" +
                    "Beware the Jabberwock, my son,\n" +
                    "The jaws that bite, the claws that catch.\n" +
                    "Beware the Jubjub bird, and shun\n" +
                    "The frumious Bandersnatch.";

    public static void main(String[] args) {
        Matcher m =
                Pattern.compile("(^[a-z]|\\s+[a-z])\\w+") // ^ 表示一行的起始，[a-z] 从 a 到 z 的任意字符，\\s+ 表示一个或者多个空白字符，\\w+ 表示一个或者多个单词字符。
                        .matcher(POEM);
        int groupCount = m.groupCount();
        System.out.println("该匹配器的模式中的分组数目，第0组不包括在内：groupCount = " + groupCount);
        Set<String> words = new LinkedHashSet<>();
        while (m.find()) {
            words.add(m.group());
        }
        System.out.println("Number of unique non-cap words = " + words.size());
        for (String word : words) {
            System.out.print("\""+word+"\", ");
        }
    }
}