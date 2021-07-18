package io.ex11;

import io.ex11.controller.Event;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

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
    public static void main(String[] args) throws IOException {
       Test.main(new String[]{"4000"});
    }
}

class Test {
    public static void main(String[] args) throws IOException {
        GreenhouseControls gc = new GreenhouseControls();
        Map<String, Long> events = readEvents();
        System.out.println(events);
        gc.addEvent(makeEvent(gc, "Bell", events.get("Bell")));
        Event[] eventList = {
                makeEvent(gc, "ThermostatNight", events.get("ThermostatNight")),
                makeEvent(gc, "LightOn", events.get("LightOn")),
                makeEvent(gc, "LightOff", events.get("LightOff")),
                makeEvent(gc, "WaterOn", events.get("WaterOn")),
                makeEvent(gc, "WaterOff", events.get("WaterOff")),
                makeEvent(gc, "ThermostatDay", events.get("ThermostatDay"))
        };
        gc.addEvent(gc.new Restart(2000, eventList));
        if (args.length == 1) {
            gc.addEvent(new GreenhouseControls.Terminate(new Integer((args[0]))));
        }
        gc.run();
    }

    private static Event makeEvent(GreenhouseControls gc, String key, Long value) {
        if (key.equals("Bell")) return new BellEventFactory().generateEvent(gc, value);
        if (key.equals("ThermostatNight")) return new ThermostatNightEventFactory().generateEvent(gc, value);
        if (key.equals("LightOn")) return new LightOnEventFactory().generateEvent(gc, value);
        if (key.equals("LightOff")) return new LightOnEventFactory().generateEvent(gc, value);
        if (key.equals("WaterOn")) return new WaterOnEventFactory().generateEvent(gc, value);
        if (key.equals("WaterOff")) return new WaterOffEventFactory().generateEvent(gc,value);
        if (key.equals("ThermostatDay")) return new ThermostatDayEventFactory().generateEvent(gc, value);
        return null;
    }

    private static Map<String, Long> readEvents() throws IOException {
        FileReader fileReader = new FileReader("D:\\Android\\Workspace\\github\\Think4JavaExamples\\exercise\\src\\io\\ex11\\Events.txt");
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        Map<String, Long> result = new HashMap<>();
        String line;
        while((line = bufferedReader.readLine()) != null) {
            String[] split = line.split("=");
            result.put(split[0], Long.valueOf(split[1]));
        }
        return result;
    }

    public interface EventFactory {
        Event generateEvent(GreenhouseControls gc, Long value);
    }

    static class BellEventFactory implements EventFactory {
        @Override
        public Event generateEvent(GreenhouseControls gc, Long value) {
            return gc.new Bell(value);
        }
    }

    static class ThermostatNightEventFactory implements EventFactory {
        @Override
        public Event generateEvent(GreenhouseControls gc, Long value) {
            return gc.new ThermostatNight(value);
        }
    }

    static class LightOnEventFactory implements EventFactory {
        @Override
        public Event generateEvent(GreenhouseControls gc, Long value) {
            return gc.new LightOn(value);
        }
    }

    static class LightOffEventFactory implements EventFactory {

        @Override
        public Event generateEvent(GreenhouseControls gc, Long value) {
            return gc.new LightOff(value);
        }
    }

    static class WaterOnEventFactory implements EventFactory {
        @Override
        public Event generateEvent(GreenhouseControls gc, Long value) {
            return gc.new WaterOn(value);
        }
    }

    static class WaterOffEventFactory implements EventFactory {
        @Override
        public Event generateEvent(GreenhouseControls gc, Long value) {
            return gc.new WaterOff(value);
        }
    }

    static class ThermostatDayEventFactory implements EventFactory {
        @Override
        public Event generateEvent(GreenhouseControls gc, Long value) {
            return gc.new ThermostatDay(value);
        }
    }
}
