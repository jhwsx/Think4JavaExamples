package interfaces._11;

/**
 * <pre>
 *     author : wangzhichao
 *     e-mail : wangzhichao@adups.com
 *     time   : 2019/07/20
 *     desc   :
 *     version: 1.0
 * </pre>
 */
class StringMixer {

    public String process(String s) {
        char[] chars = new char[s.length()];
        if (s.length() % 2 == 0) {
            for (int i = 0; i < s.length(); i += 2) {
                chars[i] = s.charAt(i + 1);
                chars[i + 1] = s.charAt(i);
            }
        } else {
            for (int i = 0; i < s.length() - 1; i += 2) {
                chars[i] = s.charAt(i + 1);
                chars[i + 1] = s.charAt(i);
            }
            chars[s.length() - 1] = s.charAt(s.length() - 1);
        }
        return new String(chars);
    }
}

class StringMixerAdapter implements Processor {

    private StringMixer stringMixer;

    public StringMixerAdapter(StringMixer stringMixer) {
        this.stringMixer = stringMixer;
    }

    @Override
    public String name() {
        return "StringMixerAdapter";
    }

    @Override
    public Object process(Object input) {
        return stringMixer.process((String) input);
    }
}

public class StringMixProcessor {
    public static void main(String[] args) {
        Apply.process(new StringMixerAdapter(new StringMixer()), "android");
    }
}
