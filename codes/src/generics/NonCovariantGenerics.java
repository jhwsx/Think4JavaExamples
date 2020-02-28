package generics;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wangzhichao
 * @since 2019/12/24
 */
public class NonCovariantGenerics {
    public static void main(String[] args) {
        // 把数组的实现
//        Fruit[] fruit = new Apple[10];
        // 改为 泛型容器的实现，可以看到直接编译不通过了：类型不兼容：需要是List<Fruit>,但发现的却是ArrayList<Apple>
        // 理解为：不能把一个涉及 Apple 的泛型赋给一个涉及 Fruit 的泛型。
//        List<Fruit> flist = new ArrayList<Apple>();
        List<Apple> apples = new ArrayList<>();
        apples.add(new Apple());
        apples.add(new Jonathan());

        List<Fruit> fruits = new ArrayList<>();
        fruits.add(new Fruit());
        fruits.add(new Jonathan());
        fruits.add(new Apple());
        fruits.add(new Orange());
    }
}
