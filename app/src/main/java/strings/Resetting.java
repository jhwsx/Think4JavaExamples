package strings;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author wangzhichao
 * @date 2019/11/02
 */
public class Resetting {
    public static void main(String[] args) {
        Matcher m = Pattern.compile("[frb][aiu][gx]").matcher("fix the rug with bags");
        while (m.find()) {
            System.out.print(m.group() + " ");
        }
        System.out.println();
        m.reset("fix the rig with bags"); // 将现有的 Matcher 对象应用于一个新的序列
//        m.reset(); // 将 Matcher 对象重新设置到当前字符序列的起始位置
        while (m.find()) {
            System.out.print(m.group() + " ");
        }
    }
}
