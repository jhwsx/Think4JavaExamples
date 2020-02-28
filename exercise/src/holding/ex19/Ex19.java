package holding.ex19;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

/**
 * <pre>
 *     author : wangzhichao
 *     e-mail : wangzhichao@adups.com
 *     time   : 2019/08/12
 *     desc   :
 *     version: 1.0
 * </pre>
 */
public class Ex19 {
    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "adups");
        map.put(3, "apple");
        map.put(2, "abup");
        map.put(5, "alibaba");
        map.put(4, "amzon");
        System.out.println(map);
//        Set<Integer> integers = new HashSet<>();
//        integers.addAll(map.keySet());
//        System.out.println("hashSet: " + integers);
//
//        Map<Integer, String> linkedMap = new LinkedHashMap<>();
//        for (Integer integer : integers) {
//            linkedMap.put(integer, map.get(integer));
//        }
//        System.out.println("from hashSet: " + linkedMap);


        Set<Integer> linkedHashSet = new LinkedHashSet<>();
        linkedHashSet.addAll(map.keySet());
        System.out.println("linkedHashSet: " + linkedHashSet);

        Map<Integer, String> linkedMap1 = new LinkedHashMap<>();
        for (Integer integer : linkedHashSet) {
            linkedMap1.put(integer, map.get(integer));
        }
        System.out.println("from linkedHashSet: " + linkedMap1);
    }
}
