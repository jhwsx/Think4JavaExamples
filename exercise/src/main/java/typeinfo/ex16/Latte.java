//: generics/coffee/Latte.java
package typeinfo.ex16;

public class Latte extends Coffee {
    public static class Factory implements typeinfo.ex16.factory.Factory<Latte> {

        @Override
        public Latte create() {
            return new Latte();
        }
    }
} ///:~
