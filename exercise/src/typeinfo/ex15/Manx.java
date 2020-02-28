//: typeinfo/pets/Manx.java
package typeinfo.ex15;

/**
 * 曼克斯猫
 */
public class Manx extends Cat {
    public Manx(String name) {
        super(name);
    }

    public Manx() {
        super();
    }

    public static class Factory implements typeinfo.ex15.factory.Factory<Manx> {
        @Override
        public Manx create() {
            return new Manx();
        }
    }
} ///:~
