package polymorphism._04;

import java.util.Random;

/**
 * @author wzc
 * @date 2019/7/13
 */
public class RandomShapeGenerator {
    private Random random = new Random();
    public Shape next() {
        int nextInt = random.nextInt(4);
        switch (nextInt) {
            default:
            case 0:
                return new Circle();
            case 1:
                return new Square();
            case 2:
                return new Triangle();
            case 3:
                return new Rectangle();
        }
    }
}
