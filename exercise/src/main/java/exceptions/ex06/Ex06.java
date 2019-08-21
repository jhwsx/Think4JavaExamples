package exceptions.ex06;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.logging.Logger;

/**
 * <pre>
 *     author : wangzhichao
 *     e-mail : wangzhichao@adups.com
 *     time   : 2019/08/21
 *     desc   :
 *     version: 1.0
 * </pre>
 */
class Exception1 extends Exception {
    private static Logger logger =
            Logger.getLogger("Exception1");
    public Exception1() {
        StringWriter trace = new StringWriter();
        printStackTrace(new PrintWriter(trace));
        logger.severe(trace.toString());
    }
}
class Exception2 extends Exception {
    private static Logger logger =
            Logger.getLogger("Exception2");
    public Exception2() {
        StringWriter trace = new StringWriter();
        printStackTrace(new PrintWriter(trace));
        logger.severe(trace.toString());
    }
}
public class Ex06 {
    public static void main(String[] args) {
        try {
            throw new Exception1();
        } catch (Exception1 exception1) {
//            exception1.printStackTrace();
        }

        try {
            throw new Exception2();
        } catch (Exception2 exception2) {
//            exception2.printStackTrace();
        }
    }
}
