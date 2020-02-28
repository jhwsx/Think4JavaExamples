package polymorphism._03;

/**
 * @author wzc
 * @date 2019/7/13
 */
public class Triangle extends Shape {
    @Override
    public void draw() {
        System.out.println("Triangle.draw()");
    }
    @Override
    public void erase() {
        System.out.println("Triangle.erase()");
    }

    @Override
    public void move() {
        System.out.println("Triangle.move()");
    }
}
