//: generics/coffee/Mocha.java
package typeinfo.ex16;

public class Mocha extends Coffee {
    public static class Factory implements typeinfo.ex16.factory.Factory<Mocha> {

        @Override
        public Mocha create() {
            return new Mocha();
        }
    }
} ///:~
