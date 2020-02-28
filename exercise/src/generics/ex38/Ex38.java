package generics.ex38;

/**
 * @author wangzhichao
 * @since 2020/01/08
 */
class Coffee {
    String operation() {
        return "coffee";
    }
}

class Decorator extends Coffee {
    protected Coffee coffee;

    public Decorator(Coffee coffee) {
        this.coffee = coffee;
    }
}

class AddMilk extends Decorator {

    public AddMilk(Coffee coffee) {
        super(coffee);
    }

    @Override
    String operation() {
        return coffee.operation() + " add milk";
    }
}

class AddFoam extends Decorator {

    public AddFoam(Coffee coffee) {
        super(coffee);
    }

    @Override
    String operation() {
        return coffee.operation() + " add foam";
    }
}

class AddChocolate extends Decorator {

    public AddChocolate(Coffee coffee) {
        super(coffee);
    }

    @Override
    String operation() {
        return coffee.operation() + " add chocolate";
    }
}

class AddSugar extends Decorator {

    public AddSugar(Coffee coffee) {
        super(coffee);
    }

    @Override
    String operation() {
        return coffee.operation() + " add sugar";
    }
}

class AddButter extends Decorator {

    public AddButter(Coffee coffee) {
        super(coffee);
    }

    @Override
    String operation() {
        return coffee.operation() + " add butter";
    }
}
public class Ex38 {
    public static void main(String[] args) {
        Coffee coffee = new Coffee();
        coffee = new AddMilk(coffee);
        coffee = new AddFoam(coffee);
        coffee = new AddChocolate(coffee);
        coffee = new AddSugar(coffee);
        coffee = new AddButter(coffee);
        System.out.println(coffee.operation());
    }
}
