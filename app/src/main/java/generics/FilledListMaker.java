package generics;


import java.util.ArrayList;
import java.util.List;

/**
 * @author wangzhichao
 * @since 2019/12/19
 */
public class FilledListMaker<T> {
    List<T> create(T t, int n) {
        List<T> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            result.add(t);
        }
        return result;
    }

    public static void main(String[] args) {
        FilledListMaker<String> stringMaker = new FilledListMaker<>();
        // 泛型在编译器确保需要的类型是 String
        List<String> list = stringMaker.create("Hello", 4);
        // 下面这行编译不通过
//        List<String> list = stringMaker.create(5, 4);
        System.out.println(list);
    }
}
