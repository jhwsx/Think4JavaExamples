package annotations;

import net.mindview.atunit.Test;

import java.io.FileInputStream;
import java.io.IOException;

/**
 * assert 和异常：一个失败的 assert 或者从方法从抛出的异常都被视为测试失败
 *
 * @author wangzhichao
 * @since 2020/5/14
 */
public class AtUnitExample2 {

    public String methodOne() {
        return "This is methodOne";
    }

    public int methodTwo() {
        System.out.println("This is methodTwo");
        return 2;
    }

    @Test
    void assertExample() {
        assert methodOne().equals("This is methodOne");
    }

    @Test
    void assertFailureExample() {
        assert 1 == 2 : "What a surprise!";
    }

    @Test
    void exceptionExample() throws IOException {
        // 这是 jdk7 关闭流的新特性，在小括号里就把流给关闭了，这里没有捕获异常。因为没有 catch 语句v
        try (FileInputStream fis = new FileInputStream("nofile.txt")) {
        }
        // catch (IOException E) {}
    }

    @Test
    boolean assertAndReturn() {
        assert methodTwo() == 2 : "methodTwo must equal 2";
        return methodOne().equals("This is methodOne");
    }
}
