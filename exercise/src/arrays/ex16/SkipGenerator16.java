package arrays.ex16;

public class SkipGenerator16 {
    public static class Boolean implements SkipGenerator<java.lang.Boolean> {
        private boolean value = false;
        private int n;

        Boolean(int n) {
            this.n = n;
        }

        @Override
        public java.lang.Boolean next() {
            return !value;
        }

        @Override
        public java.lang.Boolean next(int n) {
            value = n % 2 == 0 ? true : false;
            return value;
        }
    }

    public static class Byte implements SkipGenerator<java.lang.Byte> {
        private byte value = 0;
        private int n;

        Byte(int n) {
            this.n = n;
        }

        @Override
        public java.lang.Byte next(int n) {
            return value += n;
        }

        @Override
        public java.lang.Byte next() {
            return value++;
        }
    }

    static char[] chars = ("abcdefghijklmnopqrstuvwxyz" +
            "ABCDEFGHIJKLMNOPQRSTUVWXYZ").toCharArray();

    public static class Character implements SkipGenerator<java.lang.Character> {
        int index = -1;
        private int n;

        Character() {
            index = -1;
        }

        Character(int n) {
            this.n = n;
        }

        @Override
        public java.lang.Character next(int n) {
            index = (index + 1 + n) % chars.length;
            return chars[index];
        }

        @Override
        public java.lang.Character next() {
            index = (index + 1) % chars.length;
            return chars[index];
        }
    }

    public static class String implements SkipGenerator<java.lang.String> {
        private int length = 7;
        SkipGenerator<java.lang.Character> cg = new Character();

        public String() {

        }

        public String(int length) {
            this.length = length;
        }

        @Override
        public java.lang.String next(int n) {
            char[] buf = new char[length];
            for (int i = 0; i < length; i++) {
                buf[i] = cg.next(n);
            }
            return new java.lang.String(buf);
        }

        @Override
        public java.lang.String next() {
            char[] buf = new char[length];
            for (int i = 0; i < length; i++) {
                buf[i] = cg.next();
            }
            return new java.lang.String(buf);
        }
    }

    public static class Short implements SkipGenerator<java.lang.Short> {
        private short value = 0;
        private int n;

        Short() {
        }

        Short(int n) {
            this.n = n;
        }

        @Override
        public java.lang.Short next(int n) {
            return value += n;
        }

        @Override
        public java.lang.Short next() {
            return value++;
        }
    }

    public static class Integer implements SkipGenerator<java.lang.Integer> {
        private int value = 0;
        private int n;

        Integer() {

        }

        Integer(int n) {
            this.n = n;
        }


        @Override
        public java.lang.Integer next(int n) {
            return value += n;
        }

        @Override
        public java.lang.Integer next() {
            return value++;
        }
    }

    public static class Long implements SkipGenerator<java.lang.Long> {

        private long value = 0;
        private int n;

        Long() {

        }

        Long(int n) {
            this.n = n;
        }

        @Override
        public java.lang.Long next(int n) {
            return value += n;
        }

        @Override
        public java.lang.Long next() {
            return value++;
        }
    }

    public static class Float implements SkipGenerator<java.lang.Float> {
        private float value = 0;
        private int n;
        public Float() {}
        public Float(int n) {
            this.n = n;
        }
        @Override
        public java.lang.Float next(int n) {
            float result = value;
            value += (1.0 * n);
            return result;
        }

        @Override
        public java.lang.Float next() {
            float result = value;
            value += 1.0;
            return result;
        }
    }

    public static class Double implements SkipGenerator<java.lang.Double> {
        private double value = 0.0;
        private int n;
        public Double() {}

        public Double(int n) {
            this.n = n;
        }
        @Override
        public java.lang.Double next(int n) {
            double result = value;
            value += (1.0 * n);
            return result;
        }

        @Override
        public java.lang.Double next() {
            double result = value;
            value += 1.0;
            return result;
        }
    }


}
