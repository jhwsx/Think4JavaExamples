package generics.ex04;

import java.util.ArrayList;
import java.util.List;

/**
 * <pre>
 *     author : wangzhichao
 *     e-mail : wangzhichao@adups.com
 *     time   : 2019/07/23
 *     desc   : 迭代器模式
 *     version: 1.0
 * </pre>
 */
interface Selector {
    boolean end();

    Object current();

    void next();
}

public class Sequence<T> {
    private List<T> items;
    private int next = 0;

    public Sequence(List<T> list) {
        items = list;
    }

    public void add(T x) {
        items.add(x);
    }

    private class SequenceSelector implements Selector {
        private int i = 0;
        @Override
        public boolean end() {
            return i == items.size();
        }

        @Override
        public Object current() {
            return items.get(i);
        }

        @Override
        public void next() {
            if (i < items.size()) {
                i++;
            }
        }
    }

    public Selector selector() {
        return new SequenceSelector();
    }

    public static void main(String[] args) {
        Sequence<String> sequence = new Sequence<>(new ArrayList<String>());
        for (int i = 0; i < 10; i++) {
            sequence.add(Integer.toString(i));
        }
        Selector selector = sequence.selector();
        while (!selector.end()) {
            System.out.println(selector.current());
            selector.next();
        }
    }
}
