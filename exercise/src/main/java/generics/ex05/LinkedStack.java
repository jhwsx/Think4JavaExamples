package generics.ex05;

/**
 * 一个堆栈类
 * <p>
 * 内部类可以访问其外部类的类型参数
 *
 * @author wangzhichao
 * @since 2019/12/08
 */
public class LinkedStack<T> {
    // make Node a nonstatic class to access nonstatic T:
    private /*static*/ class Node {
        private T item;
        private Node next;

        public Node() {
            item = null;
            next = null;
        }

        public Node(T item, Node next) {
            this.item = item;
            this.next = next;
        }

        public boolean end() {
            return item == null && next == null;
        }
    }

    // end sentinel 末端哨兵
    private Node top = new Node();

    public void push(T item) {
        top = new Node(item, top);
    }

    public T pop() {
        T result = top.item;
        ;
        if (!top.end()) {
            top = top.next;
        }
        return result;
    }

    public static void main(String[] args) {
        LinkedStack<String> linkedStack = new LinkedStack<>();
        for (String s : "Phasers on stun!".split(" ")) {
            linkedStack.push(s);
        }
        String item;
        while ((item = linkedStack.pop()) != null) {
            System.out.println(item);
        }
    }

}
