package holding.ex18;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeSet;

/**
 * <pre>
 *     author : wangzhichao
 *     e-mail : wangzhichao@adups.com
 *     time   : 2019/08/12
 *     desc   :
 *     version: 1.0
 * </pre>
 */
public class Ex18 {
    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "adups");
        map.put(3, "apple");
        map.put(2, "abup");
        map.put(5, "alibaba");
        map.put(4, "amzon");
        System.out.println(map);
        TreeSet<Integer> integers = new TreeSet<>();
        integers.addAll(map.keySet());
        System.out.println(integers);

        Map<Integer, String> linkedMap = new LinkedHashMap<>();
        for (Integer integer : integers) {
            linkedMap.put(integer, map.get(integer));
        }
        System.out.println(linkedMap);

    }
}
