package holding.ex17;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * <pre>
 *     author : wangzhichao
 *     e-mail : wangzhichao@adups.com
 *     time   : 2019/08/10
 *     desc   :
 *     version: 1.0
 * </pre>
 */
public class Ex17 {
    public static void main(String[] args) {
        Map<String, Gerbil> map = new HashMap<>();
        map.put("Fuzzy", new Gerbil(0));
        map.put("Spot", new Gerbil(1));
        map.put("John", new Gerbil(2));
        map.put("Peter", new Gerbil(3));
        Set<String> keySet = map.keySet();
        Iterator<String> it = keySet.iterator();
        while (it.hasNext()) {
            String key = it.next();
            Gerbil gerbil = map.get(key);
            System.out.print(key + " ");
            gerbil.hop();
        }
    }
}
