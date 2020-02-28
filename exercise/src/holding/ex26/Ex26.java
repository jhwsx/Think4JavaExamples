package holding.ex26;

import net.mindview.util.TextFile;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * <pre>
 *     author : wangzhichao
 *     e-mail : wangzhichao@adups.com
 *     time   : 2019/08/15
 *     desc   :
 *     version: 1.0
 * </pre>
 */
public class Ex26 {
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
        List<String> newList = new ArrayList<>();
        Map<Integer, String> map1 = new LinkedHashMap<>();
        Set<String> keySet = map.keySet();
        Iterator<String> it = keySet.iterator();
        while (it.hasNext()) {
            String key = it.next();
            ArrayList<Integer> locations = map.get(key);
            for (Integer location : locations) {
                map1.put(location, key);
            }
        }
        System.out.println(map1);
        Set<Integer> integers = map1.keySet();
        List<Integer> list = new ArrayList<>(integers);
        Collections.sort(list);
        System.out.println(list);
        for (int i = 0; i < list.size(); i++) {
            String s = map1.get(i);
            newList.add(s);
        }
        System.out.println(newList);
    }
}
