package strings;

public class Immutable {
    public static String upcase(String s) {
        System.out.println("s hashCode="+s.hashCode());
        return s.toUpperCase();
    }

    public static void main(String[] args) {
        String q = "howdy";
        System.out.println("q hashCode="+q.hashCode());
        System.out.println(q);
        String qq = upcase(q);
        System.out.println(qq);
        System.out.println(q);
    }
}
