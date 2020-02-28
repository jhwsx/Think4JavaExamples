package generics;

/**
 * @author wangzhichao
 * @since 2019/12/21
 */
public class ArrayOfGeneric {
    static final int SIZE = 100;
    static Generic<Integer>[] gia;
    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        // 类型转换异常
//        gia = (Generic<Integer>[]) new Object[SIZE];
        // 这一行会报出转型警告，所以 main 方法上会有一行  @SuppressWarnings("unchecked")
        gia = (Generic<Integer>[])new Generic[SIZE];
        // 编译报错，Generic array creation
//        gia = new Generic<Integer>[SIZE];
        System.out.println(gia.getClass().getSimpleName());
        gia[0] = new Generic<Integer>();
        // 编译出错，需要 Integer 类型，而不是 Object 类型
//        gia[1] = new Generic<Object>();
        // 编译出错，需要 Integer 类型，而不是 Double 类型
//        gia[2] = new Generic<Double>();
        // 编译出错，需要 Integer 类型，而不是 Short 类型
//        gia[3] = new Generic<Short>();
    }
}
