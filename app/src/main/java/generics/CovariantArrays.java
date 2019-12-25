package generics;

/**
 * 数组的特殊行为：可以向导出类型的数组赋予基类型的数组引用。
 * @author wangzhichao
 * @since 2019/12/24
 */
class Fruit {
}

class Apple extends Fruit {
}

class Jonathan extends Apple {
}

class Orange extends Fruit {
}

public class CovariantArrays {
    public static void main(String[] args) {
        Fruit[] fruit = new Apple[10];
        // [Lgenerics.Apple;@1540e19d 可以看到是 Apple 类型的数组
        System.out.println(fruit);
        fruit[0] = new Apple();
        fruit[1] = new Jonathan();
        // 运行时，是 Apple[], 而不是 Fruit[] 或者 Orange[]
        try {
            // 此行编译时好的，因为编译器把一个 Fruit 对象或者 Fruit 子类的对象，赋值给一个 Fruit 引用时没有问题的。
            fruit[0] = new Fruit();
        } catch (Exception e) {
            // java.lang.ArrayStoreException: generics.Fruit
            System.out.println(e);
        }
        try {
            fruit[0] = new Orange();
        } catch (Exception e) {
            // java.lang.ArrayStoreException: generics.Orange
            System.out.println(e);
        }
    }
}
