package innerclasses.ex02;

/**
 * <pre>
 *     author : wangzhichao
 *     e-mail : wangzhichao@adups.com
 *     time   : 2019/07/23
 *     desc   :
 *     version: 1.0
 * </pre>
 */
class Book {
    private String name;

    Book(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                '}';
    }
}

interface Selector {
    boolean end();
    Object current();
    void next();
}
public class Sequence {
    private int next;
    private Object[] items;
    public Sequence(int i) {
        items = new Object[i];
    }

    public void add(Object o) {
        if (next < items.length) {
            items[next++] = o;
        }
    }

    private class SequenceSelector implements Selector {
        private int i;
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
    }

    public Selector selector() {
        return new SequenceSelector();
    }

    public static void main(String[] args) {
        Sequence sequence = new Sequence(10);
        for (int i = 0; i < 10; i++) {
            sequence.add(new Book(String.valueOf(i)));
        }
        Selector selector = sequence.selector();
        while (!selector.end()) {
            System.out.println(selector.current());
            selector.next();
        }
    }

}
