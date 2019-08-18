package holding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

/**
 * <pre>
 *     author : wangzhichao
 *     e-mail : wangzhichao@adups.com
 *     time   : 2019/08/18
 *     desc   :
 *     version: 1.0
 * </pre>
 */
class ReversibleArrayList<T> extends ArrayList<T> {
    public ReversibleArrayList(Collection<T> collection) {
        super(collection);
    }

    public Iterable<T> reversed() {
        return new Iterable<T>() {
            @Override
            public Iterator<T> iterator() {
                return new Iterator<T>() {
                    private int index = size()-1;
                    @Override
                    public boolean hasNext() {
                        return index >= 0;
                    }

                    @Override
                    public T next() {
                        return get(index--);
                    }

                    @Override
                    public void remove() {
                        throw new UnsupportedOperationException();
                    }
                };
            }
        };
    }
}
public class AdapterMethodIdiom {
    public static void main(String[] args) {
        ReversibleArrayList<String> reversibleArrayList = new ReversibleArrayList<>(
                Arrays.asList(("To be or not to be".split(" ")))
        );
        for (String s : reversibleArrayList) {
            System.out.print(s + " ");
        }
        System.out.println();

        for (String s : reversibleArrayList.reversed()) {
            System.out.print(s + " ");
        }
    }
}
