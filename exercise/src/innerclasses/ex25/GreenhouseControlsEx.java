package innerclasses.ex25;


import innerclasses.ex25.controller.Event;

/**
 * <pre>
 *     author : wangzhichao
 *     e-mail : wangzhichao@adups.com
 *     time   : 2019/07/28
 *     desc   :
 *     version: 1.0
 * </pre>
 */
public class GreenhouseControlsEx extends GreenhouseControls {
    private boolean sprinkler = false;

    public class SprinkerOn extends Event {
        public SprinkerOn(long delayTime) {
            super(delayTime);
        }

        @Override
        public void action() {
            sprinkler = true;
        }

        @Override
        public String toString() {
            return "Sprinker is on";
        }
    }

    public class SprinkerOff extends Event {
        public SprinkerOff(long delayTime) {
            super(delayTime);
        }

        @Override
        public void action() {
            sprinkler = false;
        }

        @Override
        public String toString() {
            return "Sprinker is off";
        }
    }

}
