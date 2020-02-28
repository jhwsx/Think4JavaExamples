package holding;

import net.mindview.util.TextFile;

import java.util.Set;
import java.util.TreeSet;

/**
 * <pre>
 *     author : wangzhichao
 *     e-mail : wangzhichao@adups.com
 *     time   : 2019/08/10
 *     desc   :
 *     version: 1.0
 * </pre>
 */
public class UniqueWordsAlphabetic {
    public static void main(String[] args) {
        Set<String> words = new TreeSet<String>(String.CASE_INSENSITIVE_ORDER);
        words.addAll(new TextFile(
                "G:\\AndroidWorkspaces\\Think4JavaExamples\\app\\src\\main\\java\\holding\\SetOperations.java",
                "\\W+")
        );
        System.out.println(words);
    }
}
