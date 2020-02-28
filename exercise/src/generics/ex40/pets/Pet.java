//: typeinfo/pets/Pet.java
package generics.ex40.pets;

public class Pet extends Individual {
    public Pet(String name) {
        super(name);
    }

    public Pet() {
        super();
    }

    public void speak() {
        System.out.println("Pet speak");
    }
} ///:~
