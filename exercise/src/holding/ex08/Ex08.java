package holding.ex08;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * <pre>
 *     author : wangzhichao
 *     e-mail : wangzhichao@adups.com
 *     time   : 2019/08/03
 *     desc   :
 *     version: 1.0
 * </pre>
 */
class Gerbil {
    private int gerbilNumber;
    Gerbil(int gerbilNumber) {
        this.gerbilNumber = gerbilNumber;
    }

    void hop() {
        System.out.println("hop()"+gerbilNumber);
    }
}

public class Ex08 {
    public static void main(String[] args) {
        ArrayList<Gerbil> gerbils = new ArrayList<>();
        gerbils.add(new Gerbil(1));
        gerbils.add(new Gerbil(2));
        gerbils.add(new Gerbil(3));
        gerbils.add(new Gerbil(4));
        for (int i = 0; i < gerbils.size(); i++) {
            Gerbil gerbil = gerbils.get(i);
            gerbil.hop();
        }
        System.out.println("+++++++++++++++++++++++++++");
        Iterator<Gerbil> it = gerbils.iterator();
        while (it.hasNext()) {
            Gerbil g = it.next();
            g.hop();
        }
    }
}
