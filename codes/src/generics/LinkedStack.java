package generics;

/**
 * 一个堆栈类
 *
 * @author wangzhichao
 * @since 2019/12/08
 */
public class LinkedStack<T> {
    private static class Node<U> {
        private U item;
        private Node<U> next;
        public Node() {
            item = null;
            next = null;
        }
        public Node(U item, Node<U> next) {
            this.item = item;
            this.next = next;
        }
        public boolean end() {
            return item == null && next == null;
        }
    }
    // end sentinel 末端哨兵
    private Node<T> top = new Node<>();

    public void push(T item) {
        top = new Node<>(item, top);
    }

    public T pop() {
        T result = top.item;;
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
        while ((item = linkedStack.pop() ) != null) {
            System.out.println(item);
        }
    }

}
