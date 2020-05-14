//package annotations;
//
///**
// * 这个类中有一个 public 的方法 multiply(),
// * 我们使用了 @ExtractInterface("IMultiplier") 注解了该类，
// * 希望把这个类的 public 方法抽取到一个有用的接口中。
// *
// * @author wangzhichao
// * @since 2020/4/16
// */
////@ExtractInterface("IMultiplier")
//public class Multiplier {
//    public int multiply(int x, int y) {
//        int total = 0;
//        for (int i = 0; i < x; i++) {
//            total = add(total, y);
//        }
//        return total;
//    }
//
//    private int add(int x, int y) {
//        return x + y;
//    }
//
//    public static void main(String[] args) {
//        Multiplier m = new Multiplier();
//        System.out.println("11 * 16 = " + m.multiply(11, 16));
//    }
//}
