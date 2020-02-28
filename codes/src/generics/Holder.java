package generics;

/**
 * @author wangzhichao
 * @since 2019/12/27
 */
public class Holder<T> {
    private T value;

    public Holder() {
    }

    public Holder(T val) {
        value = val;
    }

    public void set(T val) {
        value = val;
    }

    public T get() {
        return value;
    }

    @Override
    public boolean equals(Object obj) {
        return value.equals(obj);
    }

    public static void main(String[] args) {
        Holder<Apple> appleHolder = new Holder<>(new Apple());
        Apple apple = appleHolder.get();
        appleHolder.set(apple);

        // 類型不兼容: 不能把一個涉及 Apple 的泛型賦給一個涉及 Fruit 的泛型
        // Holder<Fruit> fruitHolder = appleHolder;

        // Holder<? extends Fruit> 表示具有任何從 Fruit 繼承的類型的 Holder
        // 但不是說這個 Holder 可以持有任何了類型的 Fruit，通配符引用的是明確的
        // 類型，所以這是說 fruitHolder 引用沒有指定的具體類型。
        Holder<? extends Fruit> fruitHolder = appleHolder;
        Fruit fruit = fruitHolder.get();
        System.out.println(fruit); // generics.Apple@1540e19d
        apple = (Apple) fruitHolder.get();

        try {
            Orange orange = (Orange) fruitHolder.get();
        } catch (Exception e) {
            // java.lang.ClassCastException: generics.Apple cannot be cast to generics.Orange
            System.out.println(e);
        }
        // 不允許
//        fruitHolder.set(new Apple());
//        fruitHolder.set(new Fruit());

        System.out.println(fruitHolder.equals(apple));
    }
}
