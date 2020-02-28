package arrays.ex08;

/**
 * @author wzc
 * @date 2020/1/30
 */
public class ArrayOfGenericType<T> {
    T[] array;

    public ArrayOfGenericType(int size) {
        // Type parameter T cannot be instantiated directly
        // 这是因为在运行时无法知道 T 是什么类型的，泛型擦除了。
        // array = new T[size];
        // 下面这行仍然会报警告
        array = (T[]) new Object[size];
    }

//    public <U> U[] makeArray() {
        // 编译报错：Type parameter U cannot be instantiated directly
//        return new U[10];
//    }

//    public static <V> V[] newArray() {
//        return new V[5];
//    }

    public static void main(String[] args) {
        ArrayOfGenericType<Object> genericType = new ArrayOfGenericType<>(5);
        genericType.array[0] = 5;
        genericType.array[1] = "hello";
    }
}
