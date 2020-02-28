package typeinfo.ex26;


/**
 * @author wzc
 * @date 2019/7/13
 */
interface Instrument {
    void play(Note n);

    void adjust();
}

class Wind implements Instrument {
    @Override
    public void play(Note n) {
        System.out.println("Wind.play() " + n);
    }

    @Override
    public String toString() {
        return "Wind";
    }

    @Override
    public void adjust() {
        System.out.println("Adjusting Wind");
    }

    void clearSpitValve() {
        System.out.println("Wind clearing spit valve");
    }
}

class Percussion implements Instrument {
    @Override
    public void play(Note n) {
        System.out.println("Percussion.play() " + n);
    }

    @Override
    public String toString() {
        return "Percussion";
    }

    @Override
    public void adjust() {
        System.out.println("Adjusting Percussion");
    }
}

class Stringed implements Instrument {
    @Override
    public void play(Note n) {
        System.out.println("Stringed.play() " + n);
    }

    @Override
    public String toString() {
        return "Stringed";
    }

    @Override
    public void adjust() {
        System.out.println("Adjusting Stringed");
    }
}

class Brass extends Wind {
    @Override
    public void play(Note n) {
        System.out.println("Brass.play() " + n);
    }

    @Override
    public String toString() {
        return "Brass";
    }

    @Override
    public void adjust() {
        System.out.println("Adjusting Brass");
    }

    @Override
    void clearSpitValve() {
        System.out.println("Brass clearing spit valve");
    }
}

class WoodWind extends Wind {
    @Override
    public void play(Note n) {
        System.out.println("WoodWind.play() " + n);
    }

    @Override
    public String toString() {
        return "WoodWind";
    }

    @Override
    public void adjust() {
        System.out.println("Adjusting WoodWind");
    }

    @Override
    void clearSpitValve() {
        System.out.println("WoodWind clearing spit valve");
    }
}

public class Music5 {
    public static void tune(Instrument i) {
        i.play(Note.MIDDLE_C);
    }

    public static void tuneAll(Instrument[] instruments) {
        for (Instrument instrument : instruments) {
            tune(instrument);
        }
    }

    public static void main(String[] args) {
        Instrument[] orchestra = {
                new Wind(),
                new Percussion(),
                new Stringed(),
                new Brass(),
                new WoodWind()
        };
        for (Instrument instrument : orchestra) {
            if (instrument instanceof Wind) {
                ((Wind) instrument).clearSpitValve();
            }
        }
        tuneAll(orchestra);
    }
}
