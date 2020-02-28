package typeinfo.ex10;

/**
 * @author wangzhichao
 * @date 2019/11/02
 */
public class Ex10 {
    public static void main(String[] args) {
        char[] chars = new char[]{1, 'a'};
        System.out.println(chars.getClass());
        if (chars instanceof Object) {
            System.out.println("char[] is Object");
        }
    }
}
