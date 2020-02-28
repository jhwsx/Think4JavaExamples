package access._05;

/**
 * @author wzc
 * @date 2019/6/16
 */
public class Test {
    public static void main(String[] args) {
        ClassA classA = new ClassA();
//        classA.privateField;
//        classA.privateMethod();
        String defaultField = classA.defaultField;
        classA.defaultMethod();
        String protectedField = classA.protectedField;
        classA.protectedMethod();
        String publicField = classA.publicField;
        classA.publicMethod();

    }
}

/**
 *
 G:\AndroidWorkspaces\Think4JavaExamples\exercise\src\main\java>javac access/_05/
 Test.java
 access\_05\Test.java:10: 错误: 不是语句
 classA.privateField;
 ^
 1 个错误

 G:\AndroidWorkspaces\Think4JavaExamples\exercise\src\main\java>javac access/_05/
 Test.java
 access\_05\Test.java:11: 错误: privateMethod()可以在ClassA中访问private
 classA.privateMethod();
 ^
 1 个错误

 G:\AndroidWorkspaces\Think4JavaExamples\exercise\src\main\java>
 */
