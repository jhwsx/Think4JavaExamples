package reusing;

import static net.mindview.simple.Print.print;

/**
 * @author wzc
 * @date 2019/7/12
 */
public class PlaceSetting extends Custom{
    private Spoon sp;
    private Fork fork;
    private Knife mKnife;
    private DinnerPlate mDinnerPlate;
    PlaceSetting(int i) {
        super(i + 1);
        sp = new Spoon(i + 2);
        fork = new Fork(i + 3);
        mKnife = new Knife(i + 4);
        mDinnerPlate = new DinnerPlate(i + 5);
        print("PlaceSetting constructor");
    }

    public static void main(String[] args) {
        PlaceSetting x = new PlaceSetting(9);
    }
}
class Plate {
    Plate(int i) {
        print("Plate constructor" + i);
    }
}

class DinnerPlate extends Plate {
    DinnerPlate(int i) {
        super(i);
        print("DinnerPlate constructor"+ i);
    }
}

class Utensil {
    Utensil(int i) {
        print("Utensil constructor"+ i);
    }
}
class Spoon extends Utensil {
    Spoon(int i) {
        super(i);
        print("Spoon constructor"+ i);
    }
}
 class Fork extends Utensil {
    Fork(int i) {
        super(i);
        print("Fork construc-tor"+ i);
    }
}

class Knife extends Utensil {

    Knife(int i) {
        super(i);
        print("Knife constructor"+ i);
    }
}

class Custom {
    Custom(int i) {
        print("Custom construcor"+ i);
    }
}




