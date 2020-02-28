package generics.ex28;

/**
 * @author wangzhichao
 * @since 2019/12/29
 */

import pets.Cat;
import pets.Dog;
import pets.Pet;

/**
 * Create a generic class Generic1<T> with a single method that takes an argument
 * of type T. Create a second generic class Generic2<T> with a single method that
 * returns an argument of type T. Write a generic method with a contravariant
 * argument of the first generic class that calls its method. Write a second generic
 * method with a covariant argument of the second class that calls its method. Test
 * using the typeinfo.pets library.
 */
class Generic1<T> {
    T t;
    void take(T t) {
        this.t = t;
        System.out.println("消费了："+t);
    }
}

class Generic2<T> {
    private T t;
    Generic2(T t) {
        this.t = t;
    }
    T give() {
        return t;
    }
}
public class Ex28 {

    static <T> void contra(Generic1<? super T> generic1, T t) {
        generic1.take(t);
    }
    static <T> T co(Generic2<? extends T> generic2) {
        return generic2.give();
    }

    public static void main(String[] args) {
        contra(new Generic1<Pet>(), new Cat());
        Pet pet = co(new Generic2<Pet>(new Dog()));
        System.out.println("生产了：" + pet);
    }
}

/**
 * PECS 原则：Producer Extends Consumer Super。
 */