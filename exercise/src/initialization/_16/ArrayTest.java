package initialization._16;

/**
 * @author wzc
 * @date 2019/6/11
 */
public class ArrayTest {
    public static void main(String[] args) {
        String[] arr = new String[5];
        arr[0] = "a";
        arr[1] = "b";
        arr[2] = "c";
        arr[3] = "d";
        arr[4] = "e";
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}
