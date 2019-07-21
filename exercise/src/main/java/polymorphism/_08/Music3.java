package polymorphism._08;

import java.util.Random;

/**
 * @author wzc
 * @date 2019/7/13
 */

enum Note {
    MIDDLE_C, C_SHARP,B_FLAT;
}

class Instrument {
    void play(Note n) {
        System.out.println("Instrument.play() " + n);
    }
    @Override
    public String toString() {
        return "Instrument";
    }
    void adjust() {
        System.out.println("Adjusting Instrument");
    }
}

class Wind extends Instrument {
    @Override
    void play(Note n) {
        System.out.println("Wind.play() " + n);
    }

    @Override
    public String toString() {
        return "Wind";
    }

    @Override
    void adjust() {
        System.out.println("Adjusting Wind");
    }
}

class Percussion extends Instrument {
    @Override
    void play(Note n) {
        System.out.println("Percussion.play() " + n);
    }

    @Override
    public String toString() {
        return "Percussion";
    }

    @Override
    void adjust() {
        System.out.println("Adjusting Percussion");
    }
}

class Stringed extends Instrument {
    @Override
    void play(Note n) {
        System.out.println("Stringed.play() " + n);
    }

    @Override
    public String toString() {
        return "Stringed";
    }

    @Override
    void adjust() {
        System.out.println("Adjusting Stringed");
    }
}

class Brass extends Wind {
    @Override
    void play(Note n) {
        System.out.println("Brass.play() " + n);
    }

    @Override
    public String toString() {
        return "Brass";
    }

    @Override
    void adjust() {
        System.out.println("Adjusting Brass");
    }
}

class WoodWind extends Wind {
    @Override
    void play(Note n) {
        System.out.println("WoodWind.play() " + n);
    }

    @Override
    public String toString() {
        return "WoodWind";
    }

    @Override
    void adjust() {
        System.out.println("Adjusting WoodWind");
    }
}

class Guitar extends Stringed {
    @Override
    void play(Note n) {
        System.out.println("Guitar.play() " + n);
    }

    @Override
    public String toString() {
        return "Guitar";
    }

    @Override
    void adjust() {
        System.out.println("Adjusting Guitar");
    }
}

class RandomInstrumentGenerator {
    private Random random = new Random();

    public Instrument next() {
        switch (random.nextInt(6)) {
            default:
            case 0:
                return new Wind();
            case 1:
                return new Percussion();
            case 2:
                return new Stringed();
            case 3:
                return new Brass();
            case 4:
                return new WoodWind();
            case 5:
                return new Guitar();
        }
    }
}
public class Music3 {
    public static void tune(Instrument i) {
        i.play(Note.MIDDLE_C);
    }

    public static void tuneAll(Instrument[] instruments) {
        for (Instrument instrument : instruments) {
            tune(instrument);
        }
    }
    private static RandomInstrumentGenerator generator = new RandomInstrumentGenerator();
    public static void main(String[] args) {
        Instrument[] orchestra = new Instrument[9];
        for (int i = 0; i < orchestra.length; i++) {
            orchestra[i] = generator.next();
        }
        tuneAll(orchestra);
        for (Instrument instrument : orchestra) {
            System.out.println(instrument);
        }
    }
}
