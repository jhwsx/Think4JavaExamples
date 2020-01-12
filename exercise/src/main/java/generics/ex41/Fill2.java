package generics.ex41;

import net.mindview.util.Generator;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import pets.Cat;
import pets.Dog;
import pets.Pet;
import pets.Rodent;

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
        List<Pet> carrier = new ArrayList<>();
        Fill2.fill(new AddableCollectionAdapter<Pet>(carrier), Pet.class, 3);
        Fill2.fill(Adapter.collectionAdapter(carrier), Cat.class, 2);
        for (Pet c : carrier) {
            System.out.println(c);
        }
        System.out.println("------------------------");
        AddableSimpleQueue<Pet> coffeeQueue = new AddableSimpleQueue<>();
        Fill2.fill(coffeeQueue, Dog.class, 4);
        Fill2.fill(coffeeQueue, Rodent.class, 1);

        for (Pet coffee : coffeeQueue) {
            System.out.println(coffee);
        }
    }
}

