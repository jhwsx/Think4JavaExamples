package holding;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
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
public class SortedSetOfInteger {
    public static void main(String[] args) {
        Random random = new Random(47);
        Set<Integer> intset = new TreeSet<>();
        List<Integer> integerList = new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
            int nextInt = random.nextInt(30);
            intset.add(nextInt);
            integerList.add(nextInt);
        }
        System.out.println(integerList);
        System.out.println(intset);
    }
}
