package generics;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.List;

/**
 * 使用 List.class.cast 方法来转型
 *
 * @author wangzhichao
 * @since 2020/01/04
 */
public class ClassCasting {
    @SuppressWarnings("unchecked")
    public void f(String[] args) throws Exception {
        ObjectInputStream in = new ObjectInputStream(
                new FileInputStream(args[0])
        );
        List<String> lw2 = List.class.cast(in.readObject());
        // 这样写是不对的。
//        List<Widget>.class.cast(in.readObject())

        List<String> lw3 = (List<String>)List.class.cast(in.readObject());
    }
}
