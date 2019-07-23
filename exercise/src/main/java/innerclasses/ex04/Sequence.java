package innerclasses.ex04;

/**
 * <pre>
 *     author : wangzhichao
 *     e-mail : wangzhichao@adups.com
 *     time   : 2019/07/23
 *     desc   :
 *     version: 1.0
 * </pre>
 */
interface Selector {
    boolean end();

    Object current();

    void next();

    Sequence getSequence();
}

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

    private class SequenceSelector implements Selector {
        private int i = 0;
        @Override
        public boolean end() {
            return i == items.length;
        }

        @Override
        public Object current() {
            return items[i];
        }

        @Override
        public void next() {
            if (i < items.length) {
                i++;
            }
        }
        @Override
        public Sequence getSequence() {
            return Sequence.this;
        }
    }

    public Selector selector() {
        return new SequenceSelector();
    }

    public static void main(String[] args) {
        Sequence sequence = new Sequence(10);
        System.out.println(sequence);
//        for (int i = 0; i < 10; i++) {
//            sequence.add(Integer.toString(i));
//        }
        Selector selector = sequence.selector();
//        while (!selector.end()) {
//            System.out.println(selector.current());
//            selector.next();
//        }
        Sequence sequence1 = selector.getSequence();
        System.out.println(sequence1);
    }
}
