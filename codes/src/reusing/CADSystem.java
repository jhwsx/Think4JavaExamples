package reusing;

import static net.mindview.simple.Print.print;

/**
 * @author wzc
 * @date 2019/7/12
 */
class Shape {
    Shape(int i) {
        print("Shape constructor");
    }
    void dispose() {
        print("Shape dispose");
    }
}

class Circle extends Shape {
    Circle(int i) {
        super(i);
        print("Drawing circle");
    }

    @Override
    void dispose() {
        print("Erasing Circle");
        super.dispose();
    }
}

class Triangle extends Shape {

    Triangle(int i) {
        super(i);
        print("Drawing triangle");
    }

    @Override
    void dispose() {
        print("Erasing triangle");
        super.dispose();
    }
}

class Line extends Shape {
    private int start, end;
    Line(int start, int end) {
        super(start);
        this.start = start;
        this.end = end;
        print("Drawing line: " + start + ", " + end);
    }


    @Override
    void dispose() {
        print("Erasing line: " + start + ", " + end);
        super.dispose();
    }
}

public class CADSystem extends Shape {
    private Circle mCircle;
    private Triangle mTriangle;
    private Line[] mLines = new Line[3];
    CADSystem(int i) {
        super(i + 1);
        for (int j = 0; j < mLines.length; j++) {
            mLines[j] = new Line(j, j * j);
        }
        mCircle = new Circle(1);
        mTriangle = new Triangle(1);
        print("Combined constructor");
    }

    @Override
    void dispose() {
        print("CADSystem.dispose()");
        mTriangle.dispose();
        mCircle.dispose();
        for (int i = mLines.length-1; i >= 0; i--) {
            mLines[i].dispose();
        }
        super.dispose();
    }

    public static void main(String[] args) {
        CADSystem x = new CADSystem(41);
        try {

        } finally {
            x.dispose();
        }
    }
}
