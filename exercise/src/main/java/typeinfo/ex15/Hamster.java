//: typeinfo/pets/Hamster.java
package typeinfo.ex15;

/**
 * 仓鼠
 */
public class Hamster extends Rodent {
  public Hamster(String name) { super(name); }
  public Hamster() { super(); }

  public static class Factory implements typeinfo.ex15.factory.Factory<Hamster> {
    @Override
    public Hamster create() {
      return new Hamster();
    }
  }
} ///:~
