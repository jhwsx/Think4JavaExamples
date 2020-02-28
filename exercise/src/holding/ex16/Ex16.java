package holding.ex16;

import net.mindview.util.TextFile;

import java.util.Collections;
import java.util.Set;
import java.util.TreeSet;

/**
 * <pre>
 *     author : wangzhichao
 *     e-mail : wangzhichao@adups.com
 *     time   : 2019/08/10
 *     desc   :
 *     version: 1.0
 * </pre>
 */
public class Ex16 {
    static void vowelCounter(Set<String> st){
        Set<Character> vowels = new TreeSet<>();
        Collections.addAll(vowels, 'A', 'E', 'I', 'O', 'U', 'a', 'e', 'i', 'o', 'u');
        int allVowels = 0;
        for (String s : st) {
            int count = 0;
            for (Character c : s.toCharArray()) {
                if (vowels.contains(c)) {
                    count++;
                    allVowels++;
                }
            }
            System.out.print(s + ": " + count +", ");
        }
        System.out.println();
        System.out.print("Total vowels: " + allVowels);
    }

    public static void main(String[] args) {
        Set<String> words = new TreeSet<>(new TextFile(
            "G:\\AndroidWorkspaces\\Think4JavaExamples\\exercise\\src\\main\\java\\holding\\ex15\\Stack.java","\\W+"
        ));
        System.out.println(words);
        System.out.println();
        vowelCounter(words);
    }
}
