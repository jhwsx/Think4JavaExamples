package holding;

import java.util.ArrayList;

/**
 * <pre>
 *     author : wangzhichao
 *     e-mail : wangzhichao@adups.com
 *     time   : 2019/08/03
 *     desc   :
 *     version: 1.0
 * </pre>
 */
class GrannySmith extends Apple {

}

class Gala extends Apple {

}

class Fuji extends Apple {

}

class Braeburn extends Apple {

}

public class GenericsAndUpcasting {
    public static void main(String[] args) {
        ArrayList<Apple> apples = new ArrayList<Apple>();
        apples.add(new GrannySmith());
        apples.add(new Gala());
        apples.add(new Fuji());
        apples.add(new Braeburn());
        for (Apple c : apples) {
            System.out.println(c);
        }
    }
}


/**
 * 打印结果：
 * holding.GrannySmith@1540e19d
 * holding.Gala@677327b6
 * holding.Fuji@14ae5a5
 * holding.Braeburn@7f31245a
 */
