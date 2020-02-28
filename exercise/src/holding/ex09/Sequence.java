package holding.ex09;

import java.util.Iterator;

/**
 * <pre>
 *     author : wangzhichao
 *     e-mail : wangzhichao@adups.com
 *     time   : 2019/07/23
 *     desc   : 迭代器模式
 *     version: 1.0
 * </pre>
 */
//interface Selector {
//    boolean end();
//
//    Object current();
//
//    void next();
//}

public class Sequence {
    private Object[] items;
    private int next = 0;

    public Sequence(int size) {
        items = new Object[size];
    }

    public void add(Object x) {
        if (next < items.length) {
            items[next++] = x;
        }
    }

//    private class SequenceSelector implements Selector {
//        private int i = 0;
//
//        @Override
//        public boolean end() {
//            return i == items.length;
//        }
//
//        @Override
//        public Object current() {
//            return items[i];
//        }
//
//        @Override
//        public void next() {
//            if (i < items.length) {
//                i++;
//            }
//        }
//    }

    private class SequenceIterator implements Iterator<Object> {
        private int i = 0;

        @Override
        public boolean hasNext() {
            return i < items.length;
        }

        @Override
        public Object next() {
            return items[i++];
        }

        @Override
        public void remove() {

        }
    }


//    public Selector selector() {
//        return new SequenceSelector();
//    }

    public Iterator iterator() {
        return new SequenceIterator();
    }

    public static void main(String[] args) {
        Sequence sequence = new Sequence(10);
        for (int i = 0; i < 10; i++) {
            sequence.add(Integer.toString(i));
        }
//        Selector selector = sequence.selector();
//        while (!selector.end()) {
//            System.out.println(selector.current());
//            selector.next();
//        }

        Iterator it = sequence.iterator();
        while (it.hasNext()) {
            Object next = it.next();
            System.out.println(next);
        }
    }
}
