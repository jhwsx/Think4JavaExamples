package holding.ex15;

import java.util.LinkedList;

/**
 * <pre>
 *     author : wangzhichao
 *     e-mail : wangzhichao@adups.com
 *     time   : 2019/08/10
 *     desc   :
 *     version: 1.0
 * </pre>
 */
public class Stack<T> {
    private LinkedList<T> storage = new LinkedList<>();

    // 入栈
    public void push(T t) {
        storage.addFirst(t);
    }
    // 获取栈顶元素
    public T peek() {
        return storage.getFirst();
    }
    // 移除并返回栈顶元素
    public T pop() {
        return storage.removeFirst();
    }
    // 判断栈是否为空
    public boolean empty() {
        return storage.isEmpty();
    }

    @Override
    public String toString() {
        return storage.toString();
    }
}
