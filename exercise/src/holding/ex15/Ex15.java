package holding.ex15;

/**
 * <pre>
 *     author : wangzhichao
 *     e-mail : wangzhichao@adups.com
 *     time   : 2019/08/10
 *     desc   :
 *     version: 1.0
 * </pre>
 */
public class Ex15 {
    public static void main(String[] args) {
        String s = "+U+n+c---+e+r+t---+a-+i-+n+t+y---+ -+r+u--+l+e+s---";
        char[] charArray = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < charArray.length; i++) {
            char current = charArray[i];
            if (current == '+') {
                char next = charArray[i + 1];
                stack.push(next);
                System.out.println("push:" + next);
            } else if (current == '-') {
                Character pop = stack.pop();
                System.out.println("pop: " +  pop);
            }
        }
        System.out.println(stack);
    }
}
