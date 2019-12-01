//: typeinfo/pets/EgyptianMau.java
package typeinfo.ex15;

public class EgyptianMau extends Cat {
    public EgyptianMau(String name) {
        super(name);
    }

    public EgyptianMau() {
        super();
    }

    public static class Factory implements typeinfo.ex15.factory.Factory<EgyptianMau> {
        @Override
        public EgyptianMau create() {
            return new EgyptianMau();
        }
    }
} ///:~
