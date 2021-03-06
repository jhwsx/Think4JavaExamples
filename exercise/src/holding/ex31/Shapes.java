package holding.ex31;

/**
 * @author wzc
 * @date 2019/7/13
 */
public class Shapes {
    private static RandomShapeGenerator shapeGenerator = new RandomShapeGenerator(9);

    public static void main(String[] args) {
//        Shape[] shapes = new Shape[9];
//        int length = shapes.length;
//        for (int i = 0; i < length; i++) {
//            shapes[i] = shapeGenerator.next();
//        }
//        for (Shape shape : shapes) {
//            shape.draw();
//        }
        for (Shape shape : shapeGenerator) {
            shape.draw();
        }
    }
}
