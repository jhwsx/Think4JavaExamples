package generics;

/**
 * @author wangzhichao
 * @since 2019/12/23
 */
class Color {}
interface HasColor {
    Color getColor();
}
class Colored<T extends HasColor> {
    T item;
    Colored(T item) {
        this.item = item;
    }
    T getItem() {
        return item;
    }

    Color color() {
        // 正是因为泛型 T 有边界 HasColor，所以这里 item 可以调用 getColor() 方法
        return item.getColor();
    }
}

class Dimension {
    public int x, y, z;
}

// 这里编译报错，类应该放在第一位，然后是接口
//class ColoredDimension<T extends HasColor & Dimension> { }

class ColoredDimension<T extends Dimension & HasColor> {
    T item;
    ColoredDimension(T item) {
        this.item = item;
    }
    T getItem() {
        return item;
    }

    Color color() {
        return item.getColor();
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

interface Weight {
    int weight();
}

// 和继承一样，可以有一个具体的类边界，多个接口边界
class Solid<T extends Dimension & HasColor & Weight> {
    T item;
    Solid(T item) {
        this.item = item;
    }

    Color color() {
        return item.getColor();
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

    int weight() {
        return item.weight();
    }
}

class Bounded extends Dimension implements HasColor, Weight {

    @Override
    public Color getColor() {
        return null;
    }

    @Override
    public int weight() {
        return 0;
    }
}
public class BasicBounds {
    public static void main(String[] args) {
        Solid<Bounded> solid = new Solid<>(new Bounded());
        solid.color();
        solid.getY();
        solid.weight();
    }
}
