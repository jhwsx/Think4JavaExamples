package generics.ex40;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import generics.ex40.pets.Cat;
import generics.ex40.pets.Dog;
import generics.ex40.pets.Manx;
import generics.ex40.pets.Pet;

/**
 * 实现编译器类型检查和潜在类型机制
 *
 * @author wangzhichao
 * @since 2020/01/11
 */
public class Apply {
    /**
     * 这个 apply 方法，能够将任何方法应用于某个序列中的所有对象
     * 利用可变参数
     */
    public static <T, S extends Iterable<? extends T>>
    void apply(S seq, Method f, Object... args) {
        try {
            for (T t : seq) {
                f.invoke(t, args);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    // 这是一个自定义的集合
    static class FilledList<T> extends ArrayList<T> {
        public FilledList(Class<? extends T> type, int size) {
            try {
                for (int i = 0; i < size; i++) {
                    add(type.newInstance());
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    static class ApplyTest {
        public static void main(String[] args) throws Exception {
            List<Pet> pets = new ArrayList<>();
            pets.add(new Pet());
            pets.add(new Manx());
            pets.add(new Dog());
            pets.add(new Cat());
            Apply.apply(pets, Pet.class.getMethod("speak"));

        }
    }
}

