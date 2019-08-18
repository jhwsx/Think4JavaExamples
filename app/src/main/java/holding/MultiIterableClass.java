package holding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

/**
 * <pre>
 *     author : wangzhichao
 *     e-mail : wangzhichao@adups.com
 *     time   : 2019/08/18
 *     desc   :
 *     version: 1.0
 * </pre>
 */
public class MultiIterableClass extends IterableClass {
    public Iterable<String> reversed() {
        return new Iterable<String>() {
            @Override
            public Iterator<String> iterator() {
                return new Iterator<String>() {
                    private int index = words.length - 1;

                    @Override
                    public boolean hasNext() {
                        return index >= 0;
                    }

                    @Override
                    public String next() {
                        return words[index--];
                    }
                };
            }
        };
    }

    public Iterable<String> randomized() {
        return new Iterable<String>() {
            @Override
            public Iterator<String> iterator() {
                List<String> shuffled = new ArrayList<>(Arrays.asList(words));
                Collections.shuffle(shuffled, new Random(47));
                return shuffled.iterator();
            }
        };
    }

    public static void main(String[] args) {
        MultiIterableClass multiIterableClass = new MultiIterableClass();
        for (String s : multiIterableClass.reversed()) {
            System.out.print(s + " ");
        }
        System.out.println();
        for (String s : multiIterableClass.randomized()) {
            System.out.print(s + " ");
        }
        System.out.println();
        for (String s : multiIterableClass) {
            System.out.print(s + " ");
        }
    }
}
