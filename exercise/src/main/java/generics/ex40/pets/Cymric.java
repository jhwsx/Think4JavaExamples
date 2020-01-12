//: typeinfo/pets/Cymric.java
package generics.ex40.pets;

public class Cymric extends Manx {
    public Cymric(String name) {
        super(name);
    }

    public Cymric() {
        super();
    }

    @Override
    public void speak() {
        System.out.println("Cymric speak");
    }
} ///:~
