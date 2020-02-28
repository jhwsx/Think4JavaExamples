package arrays;

/**
 * @author wzc
 * @date 2020/1/30
 */
// 参数化类
class ClassParameter<T> {
    public T[] f(T[] arg) {
        return arg;
    }
}
// 参数化方法
class MethodParameter {
    public static <T> T[] f(T[] arg) {
        return arg;
    }
}

public class ParameterizedArrayType {
    public static void main(String[] args) {
        // 编译报错：Generic array creation
//        Holder<Coffee> [] coffees = new Holder<Coffee>[10];
        // 下边这样写，有警告信息
//        Holder<Coffee>[] coffees = new Holder[10];
//        coffees[1] = new Holder<Coffee>();

        Integer[] ints = {1, 2, 3, 4, 5};
        Double[] doubles = {1.1, 2.2, 3.3, 4.4, 5.5};
        Integer[] ints2 =
                new ClassParameter<Integer>().f(ints);
        Double[] doubles2 =
                new ClassParameter<Double>().f(doubles);
        Integer[] ints3 = MethodParameter.f(ints);
        Double[] doubles3 = MethodParameter.f(doubles);
    }
}
