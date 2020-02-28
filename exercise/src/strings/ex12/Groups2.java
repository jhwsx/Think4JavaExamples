package strings.ex12;

import java.util.LinkedHashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 找出所有以w开头以e结尾的单词
 * @author wangzhichao
 * @date 2019/10/09
 */
public class Groups2 {
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
                Pattern.compile("\\bw\\S*?e\\b")
                        .matcher(POEM);
        int groupCount = m.groupCount();
        System.out.println("该匹配器的模式中的分组数目，第0组不包括在内：groupCount = " + groupCount);
        Set<String> words = new LinkedHashSet<>();
        while (m.find()) {
            words.add(m.group());
        }
        System.out.println("Number of words = " + words.size());
        for (String word : words) {
            System.out.print("\""+word+"\", ");
        }
    }
}