package arrays.ex13;

import net.mindview.util.CountingGenerator;

/**
 * @author wzc
 * @date 2020/2/1
 */
public class Ex13 {
    public static void main(String[] args) {
        String s = fillString(5);
        System.out.println(s);
    }

    private static String fillString(int length) {
        CountingGenerator.Character characterGenerator = new CountingGenerator.Character();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            sb.append(characterGenerator.next());
        }
        return sb.toString();
    }
}
