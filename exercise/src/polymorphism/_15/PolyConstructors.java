package polymorphism._15;

/**
 * @author wzc
 * @date 2019/7/14
 */
class Glyph {
    void draw() {
        System.out.println("Glyph.draw()");
    }
    Glyph() {
        System.out.println("Glyph before draw()");
        draw();
        System.out.println("Glyph after draw()");
    }
}

class RoundGlyph extends Glyph {
    private int radius = 1;

    RoundGlyph(int radius) {
        this.radius = radius;
        System.out.println("RoundGlyph.RoundGlyph(), radius = " + radius);
    }
    void draw() {
        System.out.println("RoundGlyph.draw(), radius = " + radius);
    }
}

class RectangularGlyph extends Glyph {
    private int width = 3;
    private int height = 4;

    RectangularGlyph(int width, int height) {
        this.width = width;
        this.height = height;
        System.out.println("RectanglularGlyph.RectangularGlyph(), width = " + width + ", height = " + height);
    }

    void draw() {
        System.out.println("RectanglularGlyph.draw(), width = " + width + ", height = " + height);
    }
}

public class PolyConstructors {
    public static void main(String[] args) {
        new RoundGlyph(5);
        new RectangularGlyph(5, 6);
    }
}
