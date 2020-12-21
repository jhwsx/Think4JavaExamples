package annotations;

import net.mindview.atunit.Test;
import net.mindview.atunit.TestObjectCreate;
import net.mindview.atunit.TestProperty;

import java.util.*;

/**
 * 本例子使用@TestProperty注解向单元测试中增加一些字段
 *
 * @author wangzhichao
 * @since 2020/5/14
 */
public class AtUnitExample4 {
    static String theory = "All brontosauruses " +
            "are thin at one end, much MUCH thicker in the " +
            "middle, and then thin again at the far end.";
    private String word;
    private Random rand = new Random();

    public AtUnitExample4(String word) {
        this.word = word;
    }

    public String getWord() {
        return word;
    }

    // 打乱单词
    public String scrambleWord() {
        List<Character> chars = new ArrayList<>();
        for (Character c : word.toCharArray()) {
            chars.add(c);
        }
        Collections.shuffle(chars, rand);
        StringBuilder result = new StringBuilder();
        for (Character ch : chars) {
            result.append(ch);
        }
        return result.toString();
    }
    // 由它注解的域表示只在单元测试中使用
    @TestProperty
    static List<String> input = Arrays.asList(theory.split(" "));

    @TestProperty
    static Iterator<String> words = input.iterator();

    @TestObjectCreate
    static AtUnitExample4 create() {
        if (words.hasNext()) {
            return new AtUnitExample4(words.next());
        } else {
            return null;
        }
    }

    @Test
    boolean words() {
        System.out.println("'" + getWord() + "'");
        return getWord().equals("are");
    }

    @Test
    boolean scramble1() {
        // Change to a specific seed to get verifiable results:
        rand = new Random(47);
        System.out.println("'" + getWord() + "'");
        String scrambled = scrambleWord();
        System.out.println(scrambled);
        return scrambled.equals("lAl");
    }

    @Test
    boolean scramble2() {
        rand = new Random(74);
        System.out.println("'" + getWord() + "'");
        String scrambled = scrambleWord();
        System.out.println(scrambled);
        return scrambled.equals("tsaeborornussu");
    }
}
