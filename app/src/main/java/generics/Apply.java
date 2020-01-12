package generics;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

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

    static class Shape {
        public void rotate() {
            System.out.println(this + " rotate");
        }

        public void resize(int newSize) {
            System.out.println(this + " resize " + newSize);
        }
    }

    static class Square extends Shape {
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
            List<Shape> shapes = new ArrayList<>();
            for (int i = 0; i < 10; i++) {
                shapes.add(new Shape());
            }
            Apply.apply(shapes, Shape.class.getMethod("rotate"));
            Apply.apply(shapes, Shape.class.getMethod("resize", int.class), 5);
            List<Square> squares = new ArrayList<>();
            for (int i = 0; i < 10; i++) {
                squares.add(new Square());
            }
            Apply.apply(squares, Shape.class.getMethod("rotate"));
            Apply.apply(squares, Shape.class.getMethod("resize", int.class), 5);

            Apply.apply(new FilledList<Shape>(Shape.class, 10), Shape.class.getMethod("rotate"));
            Apply.apply(new FilledList<Shape>(Square.class, 10), Shape.class.getMethod("rotate"));

            SimpleQueue<Shape> shapeQ = new SimpleQueue<>();
            for (int i = 0; i < 5; i++) {
                shapeQ.add(new Shape());
                shapeQ.add(new Square());
            }
            Apply.apply(shapeQ, Shape.class.getMethod("rotate"));
        }
    }
}

