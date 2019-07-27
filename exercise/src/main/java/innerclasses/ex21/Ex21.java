package innerclasses.ex21;

/**
 * <pre>
 *     author : wangzhichao
 *     e-mail : wangzhichao@adups.com
 *     time   : 2019/07/27
 *     desc   :
 *     version: 1.0
 * </pre>
 */
public class Ex21 implements In{

    @Override
    public int g() {
        return 5;
    }

    public static void main(String[] args) {
        NestClass.f(new Ex21());
    }
}
