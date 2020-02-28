package holding.ex22;

import net.mindview.util.TextFile;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/**
 * <pre>
 *     author : wangzhichao
 *     e-mail : wangzhichao@adups.com
 *     time   : 2019/08/13
 *     desc   :
 *     version: 1.0
 * </pre>
 */
class Element {
    public String key;
    public Integer value;

    @Override
    public String toString() {
        return "key: " + key + "=value: " + value;
    }
}
public class Ex22 {
    public static void main(String[] args) {
        List<String> words = new ArrayList<String>(
                new TextFile("G:\\AndroidWorkspaces\\Think4JavaExamples\\app\\src\\main\\java\\holding\\SetOperations.java", "\\W+")
        );
        System.out.println(words);

        Collections.sort(words, String.CASE_INSENSITIVE_ORDER);
        Set<Element> set = new LinkedHashSet<>();
        for (String key : words) {
            Element element = find(set, key);
            if (element == null) {
                Element element1 = new Element();
                element1.key = key;
                element1.value = 1;
                set.add(element1);
            } else {
                element.value += 1;
            }
        }
        System.out.println(set);
    }

    private static Element find(Set<Element> set, String key) {
        for (Element element : set) {
            if (element.key.equals(key)) {
                return element;
            }
        }
        return null;
    }
}
