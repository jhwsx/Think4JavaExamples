package innerclasses;

/**
 * <pre>
 *     author : wangzhichao
 *     e-mail : wangzhichao@adups.com
 *     time   : 2019/07/24
 *     desc   :
 *     version: 1.0
 * </pre>
 */
public class Parcel7b {
    class MyContents implements Contents {
        private int anInt = 11;
        @Override
        public int value() {
            System.out.println(this); // innerclasses.Parcel7b$MyContents@1540e19d
            return anInt;
        }
    }

    public Contents contents() {
        return new MyContents();
    }

    public static void main(String[] args) {
        Parcel7b p = new Parcel7b();
        Contents contents = p.contents();
        System.out.println(contents.value());
    }
}
