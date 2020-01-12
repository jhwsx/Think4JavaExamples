//: typeinfo/pets/Pug.java
package generics.ex40.pets;

/**
 * 哈巴狗
 */
public class Pug extends Dog {
    public Pug(String name) {
        super(name);
    }

    public Pug() {
        super();
    }

    @Override
    public void speak() {
        System.out.println("Pug speak");
    }
} ///:~
