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
public class GreenhouseController {
    public static void main(String[] args) {
       Test.main(new String[]{"40000"});
    }
}

class Test {
    public static void main(String[] args) {
        GreenhouseControlsEx gc = new GreenhouseControlsEx();
        gc.addEvent(gc.new Bell(900));
        Event[] eventList = {
                gc.new ThermostatNight(0),
                gc.new LightOn(200),
                gc.new LightOff(400),
                gc.new WaterOn(600),
                gc.new WaterOff(800),
                gc.new FanOn(1000),
                gc.new FanOff(1200),
                gc.new SprinkerOn(1400),
                gc.new SprinkerOff(1600),
                gc.new ThermostatDay(1800)
        };
        gc.addEvent(gc.new Restart(2000, eventList));
        if (args.length == 1) {
            gc.addEvent(new GreenhouseControls.Terminate(new Integer((args[0]))));
        }
        gc.run();
    }
}
