package holding.ex21;

import net.mindview.util.TextFile;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * <pre>
 *     author : wangzhichao
 *     e-mail : wangzhichao@adups.com
 *     time   : 2019/08/13
 *     desc   :
 *     version: 1.0
 * </pre>
 */
public class Ex21 {
    public static void main(String[] args) {
        List<String> words = new ArrayList<String>(
                new TextFile("G:\\AndroidWorkspaces\\Think4JavaExamples\\app\\src\\main\\java\\holding\\SetOperations.java", "\\W+")
        );
        System.out.println(words);

        Collections.sort(words, String.CASE_INSENSITIVE_ORDER);
        Map<String, Integer> amap = new LinkedHashMap<>();
        for (String key : words) {
            if (amap.containsKey(key)) {
                amap.put(key, amap.get(key) + 1);
            } else {
                amap.put(key, 1);
            }
        }
        System.out.println(amap);

    }
}

