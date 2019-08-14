package holding.ex24;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

/**
 * <pre>
 *     author : wangzhichao
 *     e-mail : wangzhichao@adups.com
 *     time   : 2019/08/14
 *     desc   :
 *     version: 1.0
 * </pre>
 */
public class Ex24 {
    public static void main(String[] args) {
        Map<String, Integer> map = new LinkedHashMap<>();
        map.put("one", 1);
        map.put("two", 2);
        map.put("three", 3);
        map.put("four", 4);
        map.put("five", 5);
        map.put("six", 6);
        map.put("seven", 7);
        map.put("eight", 8);
        map.put("nine", 9);
        map.put("ten", 10);
        System.out.println(map);
        Set<String> treeSet = new TreeSet<>(map.keySet());
        Iterator<String> iterator = treeSet.iterator();
        Map<String, Integer> temp = new LinkedHashMap<>();
        while (iterator.hasNext()) {
            String key = iterator.next();
            Integer value = map.get(key);
            temp.put(key, value);
            map.remove(key);
        }
        System.out.println(temp);
        System.out.println(map);
        map.putAll(temp);
        System.out.println(map);
    }
}
