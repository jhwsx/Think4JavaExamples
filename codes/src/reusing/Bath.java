package reusing;

/**
 * @author wzc
 * @date 2019/6/16
 */
public class Bath {
    private MyString
            s1 = new MyString("Happy"), // 在定义的时候初始化
            s2 = new MyString("Happy"),
            s3, s4;
    private Soap castille;
    private int mInt;
    private float toy;
    public Bath() {
        System.out.println("Inside Bath()");
        s3 = new MyString("joy"); // 在类的构造器总初始化
        toy = 3.14f;
        castille = new Soap();
    }

    {
        mInt = 47; // 实例初始化
        System.out.println("实例初始化");
    }

    @Override
    public String toString() {
        if (s4 == null) {
            s4 = new MyString("joy"); // 惰性初始化
        }
        return "Bath{" +
                "s1='" + s1 + '\'' +
                ", s2='" + s2 + '\'' +
                ", s3='" + s3 + '\'' +
                ", s4='" + s4 + '\'' +
                ", castille=" + castille +
                ", mInt=" + mInt +
                ", toy=" + toy +
                '}';
    }

    public static void main(String[] args) {
        Bath bath = new Bath();
        System.out.println(bath);
    }
}

class Soap {
    private String mString;

    Soap() {
        System.out.println("Soap()");
        mString = "Constructed";
    }

    @Override
    public String toString() {
        return mString;
    }
}

class MyString {
    String mString;
    MyString(String s) {
        System.out.println("MyString()" + s);
    }
    @Override
    public String toString() {
        return mString;
    }
}
