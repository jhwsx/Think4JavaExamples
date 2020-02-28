package reusing._02;

/**
 * @author wzc
 * @date 2019/6/16
 */
public class MyDetergent extends Detergent {
    public void scrub() {
        append(" MyDetergent.scrub()");
        super.scrub();
    }

    public void sterilize() {
        append(" sterilize()");
    }

    public static void main(String[] args) {
        MyDetergent myDetergent = new MyDetergent();
        myDetergent.dilute();
        myDetergent.apply();
        myDetergent.scrub();
        myDetergent.foam();
        myDetergent.sterilize();
        System.out.println(myDetergent);
    }
}
