package reusing._11;

/**
 * 学习继承语法
 *
 * @author wzc
 * @date 2019/6/16
 */
public class CleanserDelegation  {
    private Cleanser cleanser = new Cleanser();
    public void scrub() {
        cleanser.append(" CleanserDelegation scrub()");
    }
    public void foam() {
        cleanser.append(" foam()");
    }
    public void dilute() {
        cleanser.dilute();
    }
    public void apply() {
        cleanser.apply();
    }

    @Override
    public String toString() {
        return cleanser.toString();
    }

    public static void main(String[] args) {
        CleanserDelegation x = new CleanserDelegation();
        x.dilute();
        x.apply();
        x.scrub();
        x.foam();
        System.out.println(x);
        System.out.println("Testing base class");
        Cleanser.main(args);
    }
}

class Cleanser {
    private String s = "Cleanser";

    public void append(String a) {
        s += a;
    }
    public void dilute() {
        append(" dilute()");
    }
    public void apply() {
        append(" apply()");
    }
    public void scrub() {
        append(" scrub()");
    }

    @Override
    public String toString() {
        return s;
    }

    public static void main(String[] args) {
        Cleanser x = new Cleanser();
        x.dilute();
        x.apply();
        x.scrub();
        System.out.println(x);
    }
}
