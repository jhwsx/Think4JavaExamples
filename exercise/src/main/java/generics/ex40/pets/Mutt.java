//: typeinfo/pets/Mutt.java
package generics.ex40.pets;

/**
 * 杂种狗
 */
public class Mutt extends Dog {
    public Mutt(String name) {
        super(name);
    }

    public Mutt() {
        super();
    }

    @Override
    public void speak() {
        System.out.println("Mutt speak");
    }
} ///:~
