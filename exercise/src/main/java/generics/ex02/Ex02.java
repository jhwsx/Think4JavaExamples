package generics.ex02;

import androidx.annotation.NonNull;

import pets.Cat;

/**
 * @author wangzhichao
 * @since 2019/12/08
 */
class Holder<T> {
    private T x;
    private T y;
    private T z;

    public Holder(T x, T y, T z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }
    public T getX() {
        return x;
    }

    public void setX(T x) {
        this.x = x;
    }

    public T getY() {
        return y;
    }

    public void setY(T y) {
        this.y = y;
    }

    public T getZ() {
        return z;
    }

    public void setZ(T z) {
        this.z = z;
    }

    @Override
    public String toString() {
        return "x = " + x + ", y = " + y + ", z = " + z;
    }
}
public class Ex02 {
    public static void main(String[] args) {
        Cat x = new Cat("cat1");
        Cat y = new Cat("cat2");
        Cat z = new Cat("cat3");
        Holder<Cat> holder = new Holder<Cat>(x, y, z);
        System.out.println(holder);
    }
}
