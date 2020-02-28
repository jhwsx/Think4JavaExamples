package generics.ex33;

import java.util.ArrayList;

class FixedSizeStack<T> {
    private int index = 0;
    private ArrayList<T> storage;

    public FixedSizeStack(int size) {
        storage = new ArrayList<>(size);
    }

    public void push(T item) {
        storage.add(item);
    }

    @SuppressWarnings("unchecked")
    public T pop() {
        return storage.remove(storage.size() - 1);
    }

    public int getIndex() {
        return index;
    }

    public int count() {
        return storage.size();
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
        strings.push("a");
        int count = strings.count();
        for (int i = 0; i < count; i++) {
            String s = strings.pop();
            System.out.print(s + " ");
        }

    }
}