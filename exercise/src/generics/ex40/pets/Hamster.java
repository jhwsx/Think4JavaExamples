//: typeinfo/pets/Hamster.java
package generics.ex40.pets;

/**
 * 仓鼠
 */
public class Hamster extends Rodent {
  public Hamster(String name) { super(name); }
  public Hamster() { super(); }

  @Override
  public void speak() {
    System.out.println("Hamster speak");
  }
} ///:~
