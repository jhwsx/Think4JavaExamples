package typeinfo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import typeinfo.factory.Factory;

/**
 * 工厂方法模式
 *
 * @author wangzhichao
 * @date 2019/11/30
 */
class Part {
    public String toString() {
        return getClass().getSimpleName();
    }

    static List<Factory<? extends Part>> partFactories =
            new ArrayList<Factory<? extends Part>>();

    private static Random random = new Random(47);

    static {
        Collections.addAll(partFactories, new FuelFilter.Factory(), new AirFilter.Factory(), new CabinAirFilter.Factory(),
                new OilFilter.Factory(), new FanBelt.Factory(), new PowerSteeringBelt.Factory(), new GeneratorBelt.Factory());
    }

    public static Part createRandom() {
        int n = random.nextInt(partFactories.size());
        return partFactories.get(n).create();
    }
}

class Filter extends Part {
}

class FuelFilter extends Filter {
    public static class Factory implements typeinfo.factory.Factory<FuelFilter> {
        @Override
        public FuelFilter create() {
            return new FuelFilter();
        }
    }
}

class AirFilter extends Filter {
    public static class Factory implements typeinfo.factory.Factory<AirFilter> {
        @Override
        public AirFilter create() {
            return new AirFilter();
        }
    }
}

class CabinAirFilter extends Filter {
    public static class Factory implements typeinfo.factory.Factory<CabinAirFilter> {
        @Override
        public CabinAirFilter create() {
            return new CabinAirFilter();
        }
    }
}

class OilFilter extends Filter {
    public static class Factory implements typeinfo.factory.Factory<OilFilter> {
        @Override
        public OilFilter create() {
            return new OilFilter();
        }
    }
}

class Belt extends Part {

}

class FanBelt extends Belt {
    public static class Factory implements typeinfo.factory.Factory<FanBelt> {
        @Override
        public FanBelt create() {
            return new FanBelt();
        }
    }
}

class GeneratorBelt extends Belt {
    public static class Factory implements typeinfo.factory.Factory<GeneratorBelt> {
        @Override
        public GeneratorBelt create() {
            return new GeneratorBelt();
        }
    }
}

class PowerSteeringBelt extends Belt {
    public static class Factory implements typeinfo.factory.Factory<PowerSteeringBelt> {
        @Override
        public PowerSteeringBelt create() {
            return new PowerSteeringBelt();
        }
    }
}

public class RegisteredFactories {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            System.out.println(Part.createRandom());
        }
    }
}
