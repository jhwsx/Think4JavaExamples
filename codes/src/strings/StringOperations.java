package strings;

import java.util.Arrays;

public class StringOperations {
    public static void main(String[] args) {
        String str = new String("adups");
        System.out.println(str.length());
        System.out.println(str.charAt(str.length() - 1));
        char[] chars = new char[2];
        str.getChars(0, str.length()-3,chars,0);
        System.out.println(Arrays.toString(chars));
        char[] toCharArray = str.toCharArray();
        System.out.println(Arrays.toString(toCharArray));
        System.out.println(str.contains("a"));
        System.out.println(str.equals("adups"));
        System.out.println(str.compareTo("abup"));
        System.out.println(str.contentEquals("adups"));
        System.out.println(str.substring(0, 2));
        System.out.println(str.concat(" ok"));
    }
}
