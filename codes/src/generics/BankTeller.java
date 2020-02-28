package generics;

import net.mindview.util.Generator;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Random;

/**
 * 泛型可以应用于内部类以及匿名内部类
 *
 * @author wangzhichao
 * @since 2019/12/17
 */
class Customer {
    private static long counter = 1;
    private final long id = counter++;

    private Customer() {
        //no instance
    }

    @Override
    public String toString() {
        return "Customer " + id;
    }
    public static Generator<Customer> generator() {
        return new Generator<Customer>() {
            @Override
            public Customer next() {
                return new Customer();
            }
        };
    }
}

class Teller {
    private static long counter = 1;
    private final long id = counter++;

    private Teller() {
        //no instance
    }

    @Override
    public String toString() {
        return "Teller " + id;
    }

    public static Generator<Teller> generator = new Generator<Teller>() {
        @Override
        public Teller next() {
            return new Teller();
        }
    };
}

public class BankTeller {

    static void serve(Teller teller, Customer customer) {
        System.out.println(teller + " serve " + customer);
    }
    public static void main(String[] args) {
        Random random = new Random(47);
        Queue<Customer> line = new LinkedList<>();
        Generators.fill(line, Customer.generator(), 15);
        List<Teller> tellers = new ArrayList<>();
        Generators.fill(tellers, Teller.generator, 4);
        for (Customer c : line) {
            serve(tellers.get(random.nextInt(tellers.size())), c);
        }
    }
}
