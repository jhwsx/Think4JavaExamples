//: typeinfo/pets/Cat.java
package generics.ex40.pets;

public class Cat extends Pet {
    public Cat(String name) {
        super(name);
    }

    public Cat() {
        super();
    }

    @Override
    public void speak() {
        System.out.println("Cat speak");
    }
} ///:~
