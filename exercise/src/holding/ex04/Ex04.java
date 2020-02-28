package holding.ex04;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.TreeSet;

/**
 * <pre>
 *     author : wangzhichao
 *     e-mail : wangzhichao@adups.com
 *     time   : 2019/08/04
 *     desc   :
 *     version: 1.0
 * </pre>
 */
class MovieGenerator {
    int key = 0;
    String next() {
        switch (key) {
            default:
            case 0: key++;
                return "Snow White";
            case 1: key++;
                return "Lion King";
            case 2: key++;
                return "Cat and Dog";
            case 3:key++;
                return "Star Wars";
            case 4:key++;
                return "Superman";
            case 5:key++;
                return "Batman";
            case 6:key = 0;
                return "Spiderman";
        }
    }

    void fill(String[] a) {
        for (int i = 0; i < a.length; i++) {
            a[i] = next();
        }
        key = 0;
    }

    Collection fill(Collection<String> c, int n) {
        for (int i = 0; i < n; i++) {
            c.add(next());
        }
        key = 0;
        return c;
    }
}
public class Ex04 {
    public static void main(String[] args) {
        MovieGenerator generator = new MovieGenerator();
        String[] array = new String[10];
        generator.fill(array);
        System.out.println(Arrays.toString(array));
        System.out.println(generator.fill(new ArrayList<String>(), 10));
        System.out.println(generator.fill(new LinkedList<String>(), 10));
        System.out.println(generator.fill(new HashSet<String>(), 10));
        System.out.println(generator.fill(new TreeSet<String>(), 10));
        System.out.println(generator.fill(new LinkedHashSet<String>(),10));
    }
}
