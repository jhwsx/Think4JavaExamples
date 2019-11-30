package typeinfo;

/**
 * Class 引用的转型语法, 即是 cast() 方法
 * @author wangzhichao
 * @date 2019/11/30
 */
class Building {}

class House extends Building {

}
public class ClassCasts {
    public static void main(String[] args) {
        Building b = new House();
        Class<House> houseType = House.class;
        House h = houseType.cast(b);
        h = ((House) b);

        Class<? extends Building> asSubclass = houseType.asSubclass(Building.class);
    }
}
