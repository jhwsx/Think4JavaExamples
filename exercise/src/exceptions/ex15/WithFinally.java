package exceptions.ex15;

import exceptions.ex14.OnOffException1;
import exceptions.ex14.OnOffException2;
import exceptions.ex14.OnOffSwitch;
import exceptions.ex14.Switch;

public class WithFinally {
    static Switch sw = new Switch();

    public static void main(String[] args) {
        try {
            sw.on();
            OnOffSwitch.f();
        } catch (OnOffException1 onOffException1) {
            onOffException1.printStackTrace();
        } catch (OnOffException2 onOffException2) {
            onOffException2.printStackTrace();
        } finally {
            sw.off();
        }
    }
}
