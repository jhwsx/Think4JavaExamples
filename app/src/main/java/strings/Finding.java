package strings;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author wangzhichao
 * @date 2019/10/09
 */
public class Finding {
    public static void main(String[] args) {
        Matcher m = Pattern.compile("\\w+") // 匹配单词
                .matcher("Evening is full of the linnet's wings");
        while (m.find()) {
            System.out.print(m.group() + ", ");
        }
        System.out.println();
        int i = 0;
        while (m.find(i)) {
            System.out.print(m.group() + ", ");
            i++;
        }
    }
}
