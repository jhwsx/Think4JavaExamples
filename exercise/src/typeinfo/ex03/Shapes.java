package typeinfo.ex03;


import java.util.Arrays;
import java.util.List;

abstract class Shape {
    void draw() {
        System.out.println(this + ".draw()");
    }

    public abstract String toString();
}

class Circle extends Shape {

    @Override
    public String toString() {
        return "Circle";
    }
}

class Square extends Shape {

    @Override
    public String toString() {
        return "Square";
    }
}

class Triangle extends Shape {

    @Override
    public String toString() {
        return "Triangle";
    }
}

class Rhomboid extends Shape {

    @Override
    public String toString() {
        return "Rhomboid";
    }
}
public class Shapes {
    public static void main(String[] args) {
        List<Shape> shapeList = Arrays.asList(new Circle(), new Square(), new Triangle());
        for (Shape shape : shapeList) {
            shape.draw();
        }

        Shape rhomboid = new Rhomboid();
        Rhomboid r = (Rhomboid) rhomboid;
        Circle c = (Circle) rhomboid; // Exception in thread "main" java.lang.ClassCastException: typeinfo.ex03.Rhomboid cannot be cast to typeinfo.ex03.Circle

    }
}