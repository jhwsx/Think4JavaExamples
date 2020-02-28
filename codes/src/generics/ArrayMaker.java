package generics;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @author wangzhichao
 * @since 2019/12/19
 */
public class ArrayMaker<T> {
    private Class<T> kind;
    public ArrayMaker(Class<T> kind) {
        this.kind = kind;
    }
    @SuppressWarnings("unchecked")
    T[] create(int size) {
        // 这里有警告
        return (T[]) Array.newInstance(kind, size);
    }

    public static void main(String[] args) {
        ArrayMaker<String> stringMaker =
                new ArrayMaker<>(String.class);
        String[] stringArray = stringMaker.create(9);
        System.out.println(Arrays.toString(stringArray));
    }
}
