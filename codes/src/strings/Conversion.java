package strings;

import java.math.BigInteger;
import java.util.Formatter;

/**
 * Formatter 转换
 * @author wangzhichao
 * @date 2019/09/07
 */
public class Conversion {
    public static void main(String[] args) {
        Formatter f = new Formatter(System.out);
        char u = 'a';
        System.out.println("u = 'a'");
        f.format("s: %s\n", u); // String
        // f.format("d: %d\n", u); // 整数（十进制）//此行抛异常 java.util.IllegalFormatConversionException: d != java.lang.Character
        f.format("c: %c\n", u); // Unicode 字符
        f.format("b: %b\n", u); // Boolean 值，这个第一次用
        // f.format("f: %f\n", u); // 浮点数（十进制）// 此行抛异常：java.util.IllegalFormatConversionException: f != java.lang.Character
        // f.format("e: %e\n", u); // 浮点数（科学计数） // java.util.IllegalFormatConversionException: e != java.lang.Character
        // f.format("x: %x\n", u); // 整数（十六进制）// java.util.IllegalFormatConversionException: x != java.lang.Character
        f.format("h: %h\n", u); // 散列码（十六进制）
        System.out.println("-----------------------------");

        int v = 121;
        System.out.println("v = 121");
        f.format("d: %d\n", v);
        f.format("c: %c\n", v);
        f.format("b: %b\n", v);
        f.format("s: %s\n", v);
        // f.format("f: %f\n", v); // java.util.IllegalFormatConversionException: f != java.lang.Integer
        // f.format("e: %e\n", v); // java.util.IllegalFormatConversionException: e != java.lang.Integer
        f.format("x: %x\n", v);
        f.format("h: %h\n", v);
        System.out.println("-----------------------------");

        BigInteger w = new BigInteger("50000000000000");
        System.out.println("w = new BigInteger(\"50000000000000\")");
        f.format("d: %d\n", w);
        // f.format("c: %c\n", w); // java.util.IllegalFormatConversionException: c != java.math.BigInteger
        f.format("b: %b\n", w);
        f.format("s: %s\n", w);
        // f.format("f: %f\n", w); // java.util.IllegalFormatConversionException: f != java.math.BigInteger
        // f.format("e: %e\n", w); // java.util.IllegalFormatConversionException: e != java.math.BigInteger
        f.format("x: %x\n", w);
        f.format("h: %h\n", w);

        System.out.println("-----------------------------");
        double x = 179.543;
        System.out.println("x = 179.543");
        // f.format("d: %d\n", x); // java.util.IllegalFormatConversionException: d != java.lang.Double
        // f.format("c: %c\n", x); // java.util.IllegalFormatConversionException: c != java.lang.Double
        f.format("b: %b\n", x);
        f.format("s: %s\n", x);
        f.format("f: %f\n", x);
        f.format("e: %e\n", x);
        // f.format("x: %x\n", x); // java.util.IllegalFormatConversionException: x != java.lang.Double
        f.format("h: %h\n", x);

        System.out.println("-----------------------------");
        Conversion y = new Conversion();
        System.out.println("y = new Conversion()");
        // f.format("d: %d\n", y); // java.util.IllegalFormatConversionException: d != strings.Conversion
        // f.format("c: %c\n", y); // java.util.IllegalFormatConversionException: c != strings.Conversion
        f.format("b: %b\n", y);
        f.format("s: %s\n", y);
        // f.format("f: %f\n", y); // java.util.IllegalFormatConversionException: f != strings.Conversion
        // f.format("e: %e\n", y); // java.util.IllegalFormatConversionException: e != strings.Conversion
        // f.format("x: %x\n", y); // java.util.IllegalFormatConversionException: x != strings.Conversion
        f.format("h: %h\n", y);

        System.out.println("-----------------------------");
        boolean z = false;
        System.out.println("z = false");
        // f.format("d: %d\n", z); // java.util.IllegalFormatConversionException: d != java.lang.Boolean
        // f.format("c: %c\n", z); // java.util.IllegalFormatConversionException: c != java.lang.Boolean
        f.format("b: %b\n", z);
        f.format("s: %s\n", z);
        // f.format("f: %f\n", z); // java.util.IllegalFormatConversionException: f != java.lang.Boolean
        // f.format("e: %e\n", z); // java.util.IllegalFormatConversionException: e != java.lang.Boolean
        // f.format("x: %x\n", z); // java.util.IllegalFormatConversionException: x != java.lang.Boolean
        f.format("h: %h\n", z);
    }
}
