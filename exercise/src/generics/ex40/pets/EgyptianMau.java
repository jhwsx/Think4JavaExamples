//: typeinfo/pets/EgyptianMau.java
package generics.ex40.pets;

public class EgyptianMau extends Cat {
    public EgyptianMau(String name) {
        super(name);
    }

    public EgyptianMau() {
        super();
    }

    @Override
    public void speak() {
        System.out.println("EgyptianMau speak");
    }
} ///:~
