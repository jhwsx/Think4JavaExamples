package generics;

/**
 * @author wangzhichao
 * @since 2019/12/23
 */
class HoldItem<T> {
    // 持有一个对象
    T item;

    HoldItem(T item) {
        this.item = item;
    }

    T getItem() {
        return item;
    }
}
// Colored2 继承于 HoldItem，它也持有一个对象 item；并且 Colored2
// 还要求 T 要是 HasColor 本身，或者 HasColor 的子类
class Colored2<T extends HasColor> extends HoldItem<T> {

    Colored2(T item) {
        super(item);
    }

    Color color() {
        return item.getColor();
    }
}
// ColoredDimension2 给 T 增加了 Dimension 这个边界
class ColoredDimension2<T extends Dimension & HasColor> extends Colored2<T> {

    ColoredDimension2(T item) {
        super(item);
    }

    int getX() {
        return item.x;
    }

    int getY() {
        return item.y;
    }

    int getZ() {
        return item.z;
    }
}
// Solid2 又给 T 增加了 Weight 这个边界
class Solid2<T extends Dimension & HasColor & Weight> extends ColoredDimension2<T> {

    Solid2(T item) {
        super(item);
    }

    int weight() {
        return item.weight();
    }
}

public class InheritBounds {
    public static void main(String[] args) {
        Solid2<Bounded> solid2 = new Solid2<>(new Bounded());
        solid2.color();
        solid2.getY();
        solid2.weight();
    }
}
