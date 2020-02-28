//: typeinfo/pets/Rodent.java
package typeinfo.ex15;

/**
 * 啮齿目动物
 */
public class Rodent extends Pet {
    public Rodent(String name) {
        super(name);
    }

    public Rodent() {
        super();
    }

    public static class Factory implements typeinfo.ex15.factory.Factory<Rodent> {
        @Override
        public Rodent create() {
            return new Rodent();
        }
    }
} ///:~
