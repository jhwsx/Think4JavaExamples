package generics;

import java.util.Arrays;
import java.util.List;

/**
 * @author wangzhichao
 * @since 2019/12/29
 */
public class GenericReading {
    // 精确类型
    static <T> T readExact(List<T> list) {
        return list.get(0);
    }

    static List<Apple> apples = Arrays.asList(new Apple());

    static List<Fruit> fruit = Arrays.asList(new Fruit());

    static void f1() {
        Apple a = readExact(apples);
        Fruit f = readExact(fruit);
        // 多态
        f = readExact(apples);
    }

    static class Reader<T> {
        T readExact(List<T> list) {
            return list.get(0);
        }
    }

    static void f2() {
        Reader<Fruit> fruitReader = new Reader<>();
        Fruit f = fruitReader.readExact(fruit);
        // 编译错误：类型不匹配，需要的是 List<Fruit>, 给我一个 List<Apple> 干啥呢？
        // fruitReader.readExact(apples);
    }

    // 协变
    static class CovariantReader<T> {
        /**
         * List<? extends T> 表示具有任何从 T 继承的类型的列表
         *
         * @param list
         * @return
         */
        T readCovariant(List<? extends T> list) {
            return list.get(0);
        }
    }

    static void f3() {
        CovariantReader<Fruit> fruitReader = new CovariantReader<>();
        Fruit f = fruitReader.readCovariant(fruit);
        Fruit a = fruitReader.readCovariant(apples);
    }

    public static void main(String[] args) {
        f1();
        f2();
        f3();
    }
}
