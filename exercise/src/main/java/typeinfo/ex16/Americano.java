//: generics/coffee/Americano.java
package typeinfo.ex16;

import typeinfo.ex16.factory.Factory;

public class Americano extends Coffee {
    public static class Factory implements typeinfo.ex16.factory.Factory<Americano> {

        @Override
        public Americano create() {
            return new Americano();
        }
    }
} ///:~
