package generics;


import java.util.ArrayList;
import java.util.List;

/**
 * @author wangzhichao
 * @since 2019/12/24
 */
public class GenericsAndCovariance {
    public static void main(String[] args) {
        // List<? extends Fruit> 读作“具有任何从 Fruit 继承的类型的列表”
        List<? extends Fruit> flist = new ArrayList<Apple>();
        // 编译错误：不能添加任何类型的对象
//        flist.add(new Apple());
//        flist.add(new Fruit());
//        flist.add(new Orange());
        // 可以添加 null，但这没有意义
        flist.add(null);

        // 我们至少知道它返回 Fruit 对象
        Fruit fruit = flist.get(0);

    }
}
