package holding.ex25;

import net.mindview.util.TextFile;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * <pre>
 *     author : wangzhichao
 *     e-mail : wangzhichao@adups.com
 *     time   : 2019/08/15
 *     desc   :
 *     version: 1.0
 * </pre>
 */
public class Ex25 {
    public static void main(String[] args) {
        List<String> words = new ArrayList<String>(
                new TextFile("G:\\AndroidWorkspaces\\Think4JavaExamples\\app\\src\\main\\java\\holding\\SetOperations.java", "\\W+")
        );
        System.out.println(words);
        Map<String, ArrayList<Integer>> map = new LinkedHashMap<>();
        for (int i = 0; i < words.size(); i++) {
            String word = words.get(i);
            if (map.containsKey(word)) {
                ArrayList<Integer> locations = map.get(word);
                locations.add(i);
            } else {
                ArrayList<Integer> locations = new ArrayList<>(i);
                locations.add(i);
                map.put(word, locations);
            }
        }
        System.out.println(map);
    }
}
