package access;

import java.io.PrintStream;

import static net.mindview.simple.Print.print;
import static net.mindview.simple.Print.printf;

/**
 * @author wzc
 * @date 2019/6/14
 */
public class PrintTest {
    public static void main(String[] args) {
        print("Adups is a good company.");
        print(1988);
        print(3.14);
        PrintStream printStream = printf("Hello %s", "Java");
        printStream.println();
    }
}
