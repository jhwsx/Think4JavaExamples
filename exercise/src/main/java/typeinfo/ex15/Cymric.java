//: typeinfo/pets/Cymric.java
package typeinfo.ex15;

public class Cymric extends Manx {
    public Cymric(String name) {
        super(name);
    }

    public Cymric() {
        super();
    }

    public static class Factory implements typeinfo.ex15.factory.Factory<Cymric> {
        @Override
        public Cymric create() {
            return new Cymric();
        }
    }
} ///:~
