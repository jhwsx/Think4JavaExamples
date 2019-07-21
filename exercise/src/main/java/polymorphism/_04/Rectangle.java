package polymorphism._04;

/**
 * @author wzc
 * @date 2019/7/13
 */
public class Rectangle extends Shape {
    @Override
    public void draw() {
        System.out.println("Rectangle.draw()");
    }

    @Override
    public void erase() {
        System.out.println("Rectangle.erase()");
    }

    @Override
    public void move() {
        System.out.println("Rectangle.move()");
    }
}
