package io;

import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.SortedMap;

/**
 * @author wangzhichao
 * @since 2021/7/24
 */
public class AvailableCharSets {
    public static void main(String[] args) {
        SortedMap<String, Charset> charSets = Charset.availableCharsets();
        Iterator<String> it = charSets.keySet().iterator();
        while (it.hasNext()) {
            String csName = it.next();
            // 打印字符集名字
            System.out.print(csName);
            // 打印字符集的别名（有多个）
            Iterator<String> aliases = charSets.get(csName).aliases().iterator();
            if (aliases.hasNext()) {
                System.out.print(":");
            }
            while (aliases.hasNext()) {
                System.out.print(aliases.next());
                if (aliases.hasNext()) {
                    System.out.print(", ");
                }
            }
            System.out.println();
        }
    }
}
