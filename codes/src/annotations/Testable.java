package annotations;

import net.mindview.atunit.Test;

/**
 * @author wangzhichao
 * @since 2020/4/13
 */
public class Testable {
    public void execute() {
        System.out.println("Executing...");
    }

    @Test
    void testExecute() {
        execute();
    }
}
