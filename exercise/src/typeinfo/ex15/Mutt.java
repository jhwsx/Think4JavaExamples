//: typeinfo/pets/Mutt.java
package typeinfo.ex15;

/**
 * 杂种狗
 */
public class Mutt extends Dog {
    public Mutt(String name) {
        super(name);
    }

    public Mutt() {
        super();
    }

    public static class Factory implements typeinfo.ex15.factory.Factory<Mutt> {
        @Override
        public Mutt create() {
            return new Mutt();
        }
    }
} ///:~
