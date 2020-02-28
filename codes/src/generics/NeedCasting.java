package generics;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.List;

/**
 * @author wangzhichao
 * @since 2020/01/04
 */
public class NeedCasting {
    @SuppressWarnings("unchecked")
    public static void f(String[] args) throws Exception {
        ObjectInputStream in = new ObjectInputStream(
                new FileInputStream(args[0])
        );
        // unchecked cast
        List<String> shapes = (List<String>) in.readObject();
        System.out.println(shapes);
    }

}
