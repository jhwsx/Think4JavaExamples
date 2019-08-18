package holding.ex31;

import java.util.Iterator;
import java.util.Random;

/**
 * @author wzc
 * @date 2019/7/13
 */
public class RandomShapeGenerator implements Iterable<Shape> {
    private Random random = new Random(47);

    public Shape next() {
        switch (random.nextInt(3)) {
            default:
            case 0:
                return new Circle();
            case 1:
                return new Square();
            case 2:
                return new Triangle();
        }
    }

    private int count = 0;

    public RandomShapeGenerator(int count) {
        this.count = count;
    }

    @Override
    public Iterator<Shape> iterator() {

        return new Iterator<Shape>() {
            private int index = 0;

            @Override
            public boolean hasNext() {
                return index < count;
            }

            @Override
            public Shape next() {
                index++;
                switch (random.nextInt(3)) {
                    default:
                    case 0:
                        return new Circle();
                    case 1:
                        return new Square();
                    case 2:
                        return new Triangle();
                }
            }
        };
    }
}
