package generics;

/**
 * 只能持有单个对象的类
 *
 * 这个类的可重用性差，无法持有其他类型的任何对象。
 *
 * @author wangzhichao
 * @since 2019/12/08
 */
class Automobile {

}

public class Holder1 {
    private Automobile a;

    public Holder1(Automobile a) {
        this.a = a;
    }

    Automobile get() {
        return a;
    }
}
