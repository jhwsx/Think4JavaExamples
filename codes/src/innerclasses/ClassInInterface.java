package innerclasses;

/**
 * <pre>
 *     author : wangzhichao
 *     e-mail : wangzhichao@adups.com
 *     time   : 2019/07/27
 *     desc   :
 *     version: 1.0
 * </pre>
 */
public interface ClassInInterface {
    void howdy();

    class Test implements ClassInInterface {

        @Override
        public void howdy() {
            System.out.println("Howdy");
        }

        public static void main(String[] args) {
            new Test().howdy();
        }
    }
}
