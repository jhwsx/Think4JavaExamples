package interfaces._10;

/**
 * @author wzc
 * @date 2019/7/13
 */
enum Note {
    MIDDLE_C, C_SHARP,B_FLAT;
}

interface Playable {
    void play(Note n);
}
interface Instrument {
    void adjust();
}

class Wind implements Instrument,Playable {
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
}

class Percussion implements Instrument,Playable {
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

class Stringed implements Instrument,Playable {
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
}

public class Music5 {
    public static void tune(Playable i) {
        i.play(Note.MIDDLE_C);
    }

    public static void tuneAll(Playable[] instruments) {
        for (Playable instrument : instruments) {
            tune(instrument);
        }
    }

    public static void main(String[] args) {
        Playable[] orchestra = {
                new Wind(),
                new Percussion(),
                new Stringed(),
                new Brass(),
                new WoodWind()
        };
        tuneAll(orchestra);
    }
}
