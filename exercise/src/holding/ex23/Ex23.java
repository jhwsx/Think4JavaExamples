package holding.ex23;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * <pre>
 *     author : wangzhichao
 *     e-mail : wangzhichao@adups.com
 *     time   : 2019/08/14
 *     desc   :
 *     version: 1.0
 * </pre>
 */
public class Ex23 {
    public static void main(String[] args) {
        Random random = new Random();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < 100; i++) {
            test(random, map);
        }
        System.out.println(map);
        int max = 0;
        int keys = 0;
        for (Integer key : map.keySet()) {
            Integer value = map.get(key);
            if (value > max) {
                max = value;
                keys = key;
            }
        }
        System.out.println("max key: " + keys + ", value = " + max);
    }

    private static void test(Random random, Map<Integer, Integer> map) {
        for (int i = 0; i < 10000; i++) {
            int r = random.nextInt(20);
            Integer freq = map.get(r);
            map.put(r, freq == null ? 1 : freq + 1);
        }
    }
}
