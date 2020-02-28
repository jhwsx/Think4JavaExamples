//: typeinfo/pets/Mouse.java
package typeinfo.ex15;

/**
 * 小老鼠
 */
public class Mouse extends Rodent {
    public Mouse(String name) {
        super(name);
    }

    public Mouse() {
        super();
    }

    public static class Factory implements typeinfo.ex15.factory.Factory<Mouse> {
        @Override
        public Mouse create() {
            return new Mouse();
        }
    }
} ///:~
