package innerclasses;

/**
 * <pre>
 *     author : wangzhichao
 *     e-mail : wangzhichao@adups.com
 *     time   : 2019/07/24
 *     desc   : 匿名内部类
 *     version: 1.0
 * </pre>
 */
public class Parcel7 {
    public Contents contents() {
        return new Contents() {
            private int i = 11;
            @Override
            public int value() {
                System.out.println(this); // innerclasses.Parcel7$1@1540e19d
                return i;
            }
        };
    }

    public static void main(String[] args) {
        Parcel7 p = new Parcel7();
        Contents contents = p.contents();
        System.out.println(contents.value());
    }

}
