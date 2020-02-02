package arrays.ex16;

/**
 * @author wzc
 * @date 2020/2/3
 */
public class Generated16 {
    public static <T> T[] array(T[] a, SkipGenerator<T> gen, int skip) {
        return new CollectionData16<T>(gen, skip, a.length).toArray(a);
    }

    public static <T> T[] array(Class<T> type,
                                SkipGenerator<T> gen, int skip, int size) {
        T[] a =
                (T[])java.lang.reflect.Array.newInstance(type, size);
        return new CollectionData16<T>(gen, skip, size).toArray(a);
    }
}
