package typeinfo.ex06;


import java.util.Arrays;
import java.util.List;

abstract class Shape {
    void draw() {
        System.out.println(this + ".draw()");
    }

    public abstract String toString();
}

class Circle extends Shape {
    boolean flag = false;

    @Override
    public String toString() {
        return (flag ? "Highlighted " : "Unhighlighted ") + "Circle";
    }
}

class Square extends Shape {
    boolean flag = false;

    @Override
    public String toString() {
        return (flag ? "Highlighted " : "Unhighlighted ") + "Square";
    }
}

class Triangle extends Shape {
    boolean flag = false;

    @Override
    public String toString() {
        return (flag ? "Highlighted " : "Unhighlighted ") + "Triangle";
    }
}

class Rhomboid extends Shape {
    boolean flag = false;

    @Override
    public String toString() {
        return (flag ? "Highlighted " : "Unhighlighted ") + "Rhomboid";
    }
}

public class Shapes {
    public static void main(String[] args) {
        List<Shape> shapeList = Arrays.asList(new Circle(), new Square(), new Triangle());
        for (Shape shape : shapeList) {
            if (shape instanceof Circle) {
                ((Circle) shape).flag = true;
            }
            shape.draw();
        }
    }
}