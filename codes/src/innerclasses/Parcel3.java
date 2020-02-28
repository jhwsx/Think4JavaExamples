package innerclasses;

/**
 * <pre>
 *     author : wangzhichao
 *     e-mail : wangzhichao@adups.com
 *     time   : 2019/07/22
 *     desc   :
 *     version: 1.0
 * </pre>
 */
public class Parcel3 {
    class Contents {
        private int i = 11;
        public int value() {
            return i;
        }
    }

    class Destination {
        private String label;

        Destination(String whereTo) {
            label = whereTo;
        }
        String readLabel() {
            return label;
        }
    }

//    public Destination to(String s) {
//        return new Destination(s);
//    }

//    public Contents contents() {
//        return new Contents();
//    }

//    public void ship(String dest) {
//        Contents contents = contents();
//        Destination destination = to(dest);
//        System.out.println(destination.readLabel());
//    }

    public static void main(String[] args) {
//        Parcel3 parcel2 = new Parcel3();
//        parcel2.ship("Tasmania");
//        Parcel3 parcel21 = new Parcel3();
//        Parcel3.Contents contents = parcel21.contents();
//        Parcel3.Destination borneo = parcel21.to("Borneo");
        Parcel3 p = new Parcel3();
        Contents contents = p.new Contents();
        Destination d = p.new Destination("Tasmania");
    }

}
