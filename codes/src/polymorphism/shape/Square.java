package polymorphism.shape;

/**
 * @author wzc
 * @date 2019/7/13
 */
public class Square extends Shape {
    public void draw() {
        System.out.println("Square.draw()");
    }
    public void erase() {
        System.out.println("Square.erase()");
    }
}
