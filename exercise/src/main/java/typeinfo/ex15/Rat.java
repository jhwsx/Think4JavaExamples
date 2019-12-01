//: typeinfo/pets/Rat.java
package typeinfo.ex15;

/**
 * 大老鼠
 */
public class Rat extends Rodent {
    public Rat(String name) {
        super(name);
    }

    public Rat() {
        super();
    }

    public static class Factory implements typeinfo.ex15.factory.Factory<Rat> {
        @Override
        public Rat create() {
            return new Rat();
        }
    }
} ///:~
