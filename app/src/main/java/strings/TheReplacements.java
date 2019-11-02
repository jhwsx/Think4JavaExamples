package strings;

import net.mindview.util.TextFile;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*! Here's a block of text to use as input to
    the regular expression matcher. Note that we'll
    first extract the block of text by looking for
    the special delimiters, then process the
    extracted block. !*/

/**
 * @author wangzhichao
 * @date 2019/11/01
 */
public class TheReplacements {
    public static void main(String[] args) {
        String s = TextFile.read("G:\\AndroidWorkspaces\\Think4JavaExamples\\app\\src\\main\\java\\strings\\TheReplacements.java");
        Matcher mInput = Pattern.compile("/\\*!(.*)!\\*/", Pattern.DOTALL).matcher(s);
        if (mInput.find()) {
            System.out.println("groupCount=" + mInput.groupCount()); // 1, 不包括第 0 组
            s = mInput.group(1);
        }
        // 使用单个空格来替换2个或2个以上的空格
        s = s.replaceAll(" {2,}", " "); // " {2,}" 表示至少2次空格
        // 删除每行开头部分的所有空格，启用了多行模式Pattern.MULTILINE(?m)
        s = s.replaceAll("(?m)^ +", ""); // (?m) 启用多行模式 " +",表示至少一次空格
        System.out.println(s);
        s = s.replaceFirst("[aeiou]", "(VOWEL1)"); // 找到第一个匹配[aeiou](表示a,e,i,o 或者 u)的，替换为(VOWEL1)
        System.out.println(s);
        StringBuffer sbuf = new StringBuffer();
        Pattern p = Pattern.compile("[aeiou]");
        Matcher m = p.matcher(s);
        while (m.find()) {
            m.appendReplacement(sbuf, m.group().toUpperCase());
        }
        m.appendTail(sbuf);
        System.out.println(sbuf);
    }
}
