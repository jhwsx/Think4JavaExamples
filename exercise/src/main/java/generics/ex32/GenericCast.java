package generics.ex32;

/*
 * Verify that FixedSizeStack in GenericCast.java generates exceptions
 * if you try to go out of its bounds. Does this mean that bounds-checking
 * code is not required?
 */
class FixedSizeStack<T> {
    private int index = 0;
    private Object[] storage;

    public FixedSizeStack(int size) {
        storage = new Object[size];
    }

    public void push(T item) {
        storage[index++] = item;
    }

    @SuppressWarnings("unchecked")
    public T pop() {
        // pop 方法实际上没有执行任何转型。
        // T 被擦除到它的第一个边界，默认情况下是 Object，
        // 因此，pop() 实际上只是将 Object 转型为 Object。
        Object o = storage[--index];
        System.out.println("o = " + o.getClass());
        T t = (T) o;
        System.out.println("t = " + t.getClass());
        return t;
    }

    public int getIndex() {
        return index;
    }
}

public class GenericCast {
    public static final int SIZE = 10;

    public static void main(String[] args) {
        FixedSizeStack<String> strings =
                new FixedSizeStack<>(SIZE);
        for (String s : "A B C D E F G H I J".split(" ")) {
            strings.push(s);
        }
        if (strings.getIndex() < SIZE) {
            strings.push("a");
        }

        for (int i = 0; i < SIZE; i++) {
            String s = strings.pop();
//            System.out.print(s + " ");
        }
        if (strings.getIndex() > 0) {
            strings.pop();
        }
    }
}