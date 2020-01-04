package generics.ex30;

import generics.ex29.Holder;

/**
 * @author wangzhichao
 * @since 2020/01/04
 */
public class Ex30 {
    public static void main(String[] args) {
        Holder<Boolean> booleanHolder = new Holder<>();
        booleanHolder.set(new Boolean(true));
        Boolean aBoolean = booleanHolder.get();
        System.out.println("aBoolean = " + aBoolean);
        booleanHolder.set(false);
        boolean b = booleanHolder.get();
        System.out.println("b = " + b);

        Holder<Byte> byteHolder = new Holder<>();
        byteHolder.set(new Byte("1"));
        Byte aByte = byteHolder.get();
        System.out.println("aByte = " + aByte);
        byteHolder.set((byte) 2);
        byte aByte1 = byteHolder.get();
        System.out.println("aByte1 = " + aByte1);

        Holder<Character> characterHolder = new Holder<>();
        characterHolder.set(Character.MAX_HIGH_SURROGATE);
        Character character = characterHolder.get();
        System.out.println("character = " + character);
        characterHolder.set('a');
        char c = characterHolder.get();
        System.out.println("c = " + c);

        Holder<Short> shortHolder = new Holder<>();
        shortHolder.set(Short.valueOf("12345"));
        Short aShort = shortHolder.get();
        System.out.println("aShort = " + aShort);
        shortHolder.set((short) 65534);
        short sh = shortHolder.get();
        System.out.println("sh = " + sh);

        Holder<Integer> integerHolder = new Holder<>();
        integerHolder.set(Integer.valueOf(1000000000));
        Integer integer = integerHolder.get();
        System.out.println("integer = " + integer);
        integerHolder.set(100);
        int x = integerHolder.get();
        System.out.println("x = " + x);


        Holder<Long> longHolder = new Holder<>();
        longHolder.set(Long.valueOf(10L));
        Long aLong = longHolder.get();
        System.out.println("aLong = " + aLong);
        longHolder.set(1000L);
        long l = longHolder.get();
        System.out.println("l = " + l);

        Holder<Float> floatHolder = new Holder<>();
        floatHolder.set(Float.valueOf(1.5f));
        Float aFloat = floatHolder.get();
        System.out.println("aFloat = " + aFloat);
        floatHolder.set(1.6f);
        float f = floatHolder.get();
        System.out.println("f = " + f);

        Holder<Double> doubleHolder = new Holder<>();
        doubleHolder.set(Double.valueOf(1.2d));
        Double aDouble = doubleHolder.get();
        System.out.println("aDouble = " + aDouble);
        doubleHolder.set(1.3d);
        Double d = doubleHolder.get();
        System.out.println("d = " + d);

    }
}
