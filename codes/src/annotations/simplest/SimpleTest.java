package annotations.simplest;

/**
 * 编译命令参考了：https://www.cnblogs.com/xiazdong/p/3216220.html
 * @author wangzhichao
 * @since 2020/5/8
 */
@Simple
public class SimpleTest {
    @Simple
    int i;
    @Simple
    public SimpleTest() {}
    @Simple
    public void foo() {
        System.out.println("SimpleTest.foo()");
    }
    @Simple
    public void bar(String s, int i, float f) {
        System.out.println("SimpleTest.bar()");
    }

    @Simple
    public static void main(String[] args) {
        @Simple
        SimpleTest st = new SimpleTest();
        st.foo();
    }
}

/*
(base) wangzhichao@wangzhichao:~/AndroidStudioProjects/Think4JavaExamples/codes/src$ javac annotations/simplest/SimpleProcessor.java
(base) wangzhichao@wangzhichao:~/AndroidStudioProjects/Think4JavaExamples/codes/src$ javac -processor annotations.simplest.SimpleProcessor annotations/simplest/SimpleTest.java
annotations.simplest.Simple
====annotations.simplest.SimpleTest====
CLASS : [public] : SimpleTest : annotations.simplest.SimpleTest
annotations.simplest.SimpleTest
java.lang.Object
i,SimpleTest(),foo(),bar(java.lang.String,int,float),main(java.lang.String[])
====i====
FIELD : [] : i : int
====SimpleTest()====
CONSTRUCTOR : [public] : <init> : ()void
====foo()====
METHOD : [public] : foo : ()void
null foo()====bar(java.lang.String,int,float)====
METHOD : [public] : bar : (java.lang.String,int,float)void
null bar(s,i,f)====main(java.lang.String[])====
METHOD : [public, static] : main : (java.lang.String[])void

 */
