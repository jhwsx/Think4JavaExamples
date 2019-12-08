package generics.ex01;

import pets.Cat;
import pets.Hamster;
import pets.Pet;

/**
 * 指定 Holder3 可以持有某个基类类型，那么它也能持有导出类型。
 *
 * @author wangzhichao
 * @since 2019/12/08
 */
public class Holder3<T> {
    private T a;

    public Holder3(T a) {
        this.a = a;
    }

    public T get() {
        return a;
    }

    public void set(T a) {
        this.a = a;
    }

    public static void main(String[] args) {
        Holder3<Pet> h3 = new Holder3<>(new Pet());
        h3.set(new Cat());
        System.out.println(h3.get());
        h3.set(new Hamster());
    }
}
