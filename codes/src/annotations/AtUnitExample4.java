//package annotations;
//
//import net.mindview.util.ConvertTo;
//
//import java.util.Arrays;
//import java.util.List;
//import java.util.Random;
//
///**
// * 本例子使用@TestProperty注解向单元测试中增加一些字段
// *
// * @author wangzhichao
// * @since 2020/5/14
// */
//public class AtUnitExample4 {
//    static String theory = "All brontosauruses " +
//            "are thin at one end, much MUCH thicker in the " +
//            "middle, and then thin again at the far end.";
//    private String word;
//    private Random rand = new Random();
//
//    public AtUnitExample4(String word) {
//        this.word = word;
//    }
//    public String getWord() {
//        return word;
//    }
//    public String scrambleWord() {
//        List<Character> chars = Arrays.asList(ConvertTo.boxed(word.toCharArray()));
//
//    }
//
//}
