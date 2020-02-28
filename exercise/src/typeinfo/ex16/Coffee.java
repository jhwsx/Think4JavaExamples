//: generics/coffee/Coffee.java
package typeinfo.ex16;

public class Coffee {
  private static long counter = 0;
  private final long id = counter++;
  public String toString() {
    return getClass().getSimpleName() + " " + id;
  }

  public static class Factory implements typeinfo.ex16.factory.Factory<Coffee> {

    @Override
    public Coffee create() {
      return new Coffee();
    }
  }
} ///:~
