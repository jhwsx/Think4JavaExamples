package holding;

import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;

/**
 * <pre>
 *     author : wangzhichao
 *     e-mail : wangzhichao@adups.com
 *     time   : 2019/08/18
 *     desc   :
 *     version: 1.0
 * </pre>
 */
public class ForEachCollections {
    public static void main(String[] args) {
        Collection<String> cs = new LinkedList<>(
                Arrays.asList("Take the long way home".split(" "))
        );
        for (String c : cs) {
            System.out.print("'" + c + "'" + " ");
        }
        System.out.println();
    }
}
