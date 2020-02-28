package typeinfo;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @author wangzhichao
 * @since 2019/12/08
 */
class WithPrivateFinalField {
    private int i = 1;
    private final String s = "I'm totally safe";
    private String s2 = "Am I safe?";
    @Override
    public String toString() {
        return "i = " + i + ", " + s + ", " + s2;
    }
}
public class ModifyingPrivateFields {
    public static void main(String[] args) throws Exception {
        WithPrivateFinalField pf = new WithPrivateFinalField();
        System.out.println(pf);
        Field iField = pf.getClass().getDeclaredField("i");
        iField.setAccessible(true);
        System.out.println("iField.getInt(pf) = " + iField.getInt(pf));
        // 对于 i，设置生效
        iField.setInt(pf, 47);
        System.out.println(pf);

        Field sField = pf.getClass().getDeclaredField("s");
        sField.setAccessible(true);
        System.out.println("sField.get(pf) = " + sField.get(pf));
        // 对于 s，修改不生效
        sField.set(pf, "No, you're not!");
        System.out.println(pf);

        Field s2Field = pf.getClass().getDeclaredField("s2");
        s2Field.setAccessible(true);
        System.out.println("s2Field.get(pf) = " + s2Field.get(pf));
        // 对于 s2，修改生效
        s2Field.set(pf, "No, you're not!");
        System.out.println(pf);
    }
}
