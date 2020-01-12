package generics;

import net.mindview.util.Generator;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import generics.coffee.Coffee;
import generics.coffee.Latte;
import generics.coffee.Mocha;

/**
 * 使用适配器来模拟潜在类型机制
 *
 * @author wangzhichao
 * @since 2020/01/12
 */
// 希望的，期待的接口
interface Addable<T> {
    void add(T t);
}

public class Fill2 {
    public static <T> void fill(Addable<T> addable,
                                Class<? extends T> classToken, int size) {
        for (int i = 0; i < size; i++) {
            try {
                addable.add(classToken.newInstance());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static <T> void fill(Addable<T> addable,
                                Generator<T> generator, int size) {
        for (int i = 0; i < size; i++) {
            addable.add(generator.next());
        }
    }
}
// 对象适配器，使用的是组合
class AddableCollectionAdapter<T> implements Addable<T> {
    // 需要适配的接口，已知的接口
    private Collection<T> c;

    public AddableCollectionAdapter(Collection<T> c) {
        this.c = c;
    }

    @Override
    public void add(T t) {
        c.add(t);
    }
}

class Adapter {
    public static <T> Addable<T> collectionAdapter(Collection<T> c) {
        return new AddableCollectionAdapter<T>(c);
    }
}
// 类适配器，使用的是继承
class AddableSimpleQueue<T> extends SimpleQueue<T> implements Addable<T> {
    @Override
    public void add(T t) {
        super.add(t);
    }
}

class Fill2Test {
    public static void main(String[] args) {
        List<Coffee> carrier = new ArrayList<>();
        Fill2.fill(new AddableCollectionAdapter<Coffee>(carrier), Coffee.class, 3);
        Fill2.fill(Adapter.collectionAdapter(carrier), Latte.class, 2);
        for (Coffee c : carrier) {
            System.out.println(c);
        }
        System.out.println("------------------------");
        AddableSimpleQueue<Coffee> coffeeQueue = new AddableSimpleQueue<>();
        Fill2.fill(coffeeQueue, Mocha.class, 4);
        Fill2.fill(coffeeQueue, Latte.class, 1);

        for (Coffee coffee : coffeeQueue) {
            System.out.println(coffee);
        }
    }
}

