package generics;

/**
 * @author wangzhichao
 * @since 2019/12/21
 */
public class GenericArray<T> {
    private T[] array;
    @SuppressWarnings("unchecked")
    public GenericArray(int sz) {
        // 这一行有编译警告
        array = (T[]) new Object[sz];
    }

    public void put(int index, T item) {
        array[index] = item;
    }

    public T get(int index) {
        return array[index];
    }

    public T[] rep() {
        return array;
    }

    public static void main(String[] args) {
        GenericArray<Integer> gai = new GenericArray<>(10);
        // 此行抛出java.lang.ClassCastException: [Ljava.lang.Object; cannot be cast to [Ljava.lang.Integer;
//        Integer[] ia = gai.rep();
        // 这行是好的
        Object[] rep = gai.rep();
    }
}
