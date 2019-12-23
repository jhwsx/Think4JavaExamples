package generics;

import java.lang.reflect.Array;

/**
 * 使用类型标记
 *
 * @author wangzhichao
 * @since 2019/12/23
 */
public class GenericArrayWithTypeToken<T> {
    private T[] array;
    @SuppressWarnings("unchecked")
    public GenericArrayWithTypeToken(Class<T> type, int sz) {
        // 此行有警告：未检查的类型异常
        array = (T[]) Array.newInstance(type, sz);
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
        GenericArrayWithTypeToken<Integer> gai = new GenericArrayWithTypeToken<>(Integer.class, 10);
        for (int i = 0; i < 10; i++) {
            gai.put(i, i);
        }
        for (int i = 0; i < 10; i++) {
            Integer integer = gai.get(i);
            System.out.print(integer + " ");
        }
        System.out.println();
        // 这一行是好的，不像前面的例子，会报出类型强转异常
        Integer[] ia = gai.rep();
        System.out.println(ia);
    }
}
