package access._05;

/**
 * @author wzc
 * @date 2019/6/16
 */
public class ClassA {
    private String privateField;
    private void privateMethod() {
        System.out.println("privateMethod");
    }

    String defaultField;
    void defaultMethod() {
        System.out.println("defaultMethod");
    }

    protected String protectedField;
    protected void protectedMethod() {
        System.out.println("protectedMethod");
    }

    public String publicField;
    public void publicMethod() {
        System.out.println("publicMethod");
    }

}
