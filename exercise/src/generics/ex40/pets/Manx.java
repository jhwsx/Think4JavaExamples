//: typeinfo/pets/Manx.java
package generics.ex40.pets;

/**
 * 曼克斯猫
 */
public class Manx extends Cat {
    public Manx(String name) {
        super(name);
    }

    public Manx() {
        super();
    }

    @Override
    public void speak() {
        System.out.println("Manx speak");
    }
} ///:~
