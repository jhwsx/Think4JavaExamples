package initialization;

/**
 * @author wzc
 * @date 2019/6/5
 */
public class InitialValues {
    boolean b;
    byte c;
    char ch;
    short s;
    int i;
    float f;
    double d;
    InitialValues mInitialValues;
    void printInitialValues() {
        System.out.println("boolean " + b);
        System.out.println("byte " + c);
        System.out.println("char [" + ch+"]");
        System.out.println("short " + s);
        System.out.println("int " + i);
        System.out.println("float " + f);
        System.out.println("double " + d);
        System.out.println("InitialValues " + mInitialValues);
    }

    public static void main(String[] args) {
        InitialValues initialValues = new InitialValues();
        initialValues.printInitialValues();
    }
}
