//: typeinfo/pets/Mouse.java
package generics.ex40.pets;

/**
 * 小老鼠
 */
public class Mouse extends Rodent {
    public Mouse(String name) {
        super(name);
    }

    public Mouse() {
        super();
    }

    @Override
    public void speak() {
        System.out.println("EgyptianMau speak");
    }
} ///:~
