package innerclasses;

/**
 * <pre>
 *     author : wangzhichao
 *     e-mail : wangzhichao@adups.com
 *     time   : 2019/07/23
 *     desc   :
 *     version: 1.0
 * </pre>
 */
class Parcel4 {
    private class PContents implements Contents {
        private int i = 11;
        public int value() {
            return i;
        }
    }

    protected class PDestination implements Destination {
        private String label;

        PDestination(String whereTo) {
            label = whereTo;
        }
        public String readLabel() {
            return label;
        }
    }

    public Destination destination(String s) {
        return new PDestination(s);
    }

    public Contents contents() {
        return new PContents();
    }
}
public class TestParcel {
    public static void main(String[] args) {
        Parcel4 p = new Parcel4();
        Contents contents = p.contents();
//        (Parcel4.PContents)contents

        Destination destination = p.destination("Home");

        Parcel4.PDestination destination1 = (Parcel4.PDestination) destination;
        System.out.println(destination1);
//        p.new PContents();
        Parcel4.PDestination home = p.new PDestination("Home");
    }
}
