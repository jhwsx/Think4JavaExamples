//: typeinfo/pets/Rat.java
package generics.ex40.pets;

/**
 * 大老鼠
 */
public class Rat extends Rodent {
    public Rat(String name) {
        super(name);
    }

    public Rat() {
        super();
    }

    @Override
    public void speak() {
        System.out.println("Rat speak");
    }
} ///:~
