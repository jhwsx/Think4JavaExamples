//: generics/coffee/Cappuccino.java
package typeinfo.ex16;

public class Cappuccino extends Coffee {
    public static class Factory implements typeinfo.ex16.factory.Factory<Cappuccino> {

        @Override
        public Cappuccino create() {
            return new Cappuccino();
        }
    }
} ///:~
