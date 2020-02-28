package initialization;

/**
 * @author wzc
 * @date 2019/6/11
 */
public class EmumOrder {
    public static void main(String[] args) {
        for (Spiciness spiciness : Spiciness.values()) {
            System.out.println(spiciness +", ordinal "+spiciness.ordinal());
        }
    }
}
