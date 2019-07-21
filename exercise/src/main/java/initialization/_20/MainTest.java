package initialization._20;

/**
 * @author wzc
 * @date 2019/6/11
 */
public class MainTest {
    public static void main(String... args) {
        for (String arg : args) {
            System.out.println(arg);
        }
    }
}

class Main {
    public static void main(String[] args) {
        MainTest.main("system","javac","java");
    }
}
