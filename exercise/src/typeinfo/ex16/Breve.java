//: generics/coffee/Breve.java
package typeinfo.ex16;

public class Breve extends Coffee {
    public static class Factory implements typeinfo.ex16.factory.Factory<Breve> {

        @Override
        public Breve create() {
            return new Breve();
        }
    }
} ///:~
