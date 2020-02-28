//: typeinfo/pets/Rodent.java
package generics.ex40.pets;

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

    @Override
    public void speak() {
        System.out.println("Rodent speak");
    }
} ///:~
