package generics;

/**
 * 在内部直接使用 Object[], 而不是 T[]
 *
 * @author wangzhichao
 * @since 2019/12/21
 */
public class GenericArray2<T> {
    private Object[] array;

    public GenericArray2(int sz) {
        array = new Object[sz];
    }

    public void put(int index, T item) {
        array[index] = item;
    }

    @SuppressWarnings("unchecked")
    public T get(int index) {
        // 这一行报出警告：未检查的类型转换
        return (T) array[index];
    }

    @SuppressWarnings("unchecked")
    public T[] rep() {
        // 这一行报出警告：未检查的类型转换
        return (T[]) array;
    }

    public static void main(String[] args) {
        GenericArray2<Integer> gai = new GenericArray2<>(10);
        for (int i = 0; i < 10; i++) {
            gai.put(i, i);
        }
        for (int i = 0; i < 10; i++) {
            // 这一行，不会报错，因为存进去的确实是 Integer 类型
            Integer integer = gai.get(i);
            System.out.print(integer + " ");
        }
        System.out.println();
        try {
            Integer[] ia = gai.rep();
        } catch (Exception e) {
            // 这里会抛出异常：java.lang.ClassCastException: [Ljava.lang.Object; cannot be cast to [Ljava.lang.Integer;
            System.out.println(e);
        }
        Object[] rep = gai.rep();
        System.out.println(rep.toString());
    }
}
