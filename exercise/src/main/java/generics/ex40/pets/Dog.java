//: typeinfo/pets/Dog.java
package generics.ex40.pets;

public class Dog extends Pet {
    public Dog(String name) {
        super(name);
    }

    public Dog() {
        super();
    }

    @Override
    public void speak() {
        System.out.println("Dog speak");
    }
} ///:~
