package innerclasses;

/**
 * <pre>
 *     author : wangzhichao
 *     e-mail : wangzhichao@adups.com
 *     time   : 2019/07/27
 *     desc   :
 *     version: 1.0
 * </pre>
 */
public class Parcel11 {
    private static class ParcelContents implements Contents {
        private int i = 11;
        @Override
        public int value() {
            return i;
        }
    }

    protected static class ParcelDestination implements Destination {
        private String label;

        public ParcelDestination(String whereTo) {
            this.label = whereTo;
        }

        @Override
        public String readLabel() {
            return label;
        }

        public static void f() {

        }

        static int x = 10;

        static class AnotherLevel {
            public static void f() {

            }
            static int x = 10;
        }
    }

    public static Destination destination(String s) {
        return new ParcelDestination(s);
    }

    private class Inner {
        // 普通内部类不能有static 数据和static 字段，也不能包含嵌套类。
        //        static int x = 10;
//        static int get() {
//            return 5;
//        }
//        static class NestClass {
//
//        }
        int y = 10;
    }

    public static Contents contents() {
        return new ParcelContents();
    }

    public static void main(String[] args) {
        Contents contents = contents();
        Destination destination = destination("henan");
    }

}
