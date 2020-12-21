package annotations;

import java.util.LinkedList;

/**
 * 这是一个栈结构
 * @author wangzhichao
 * @since 2020/12/22
 */
public class StackL<T> {
    private LinkedList<T> list = new LinkedList<>();

    public void push(T v) {
        list.addFirst(v);
    }

    public T top() {
        return list.getFirst();
    }

    public T pop() {
        return list.removeFirst();
    }
}
