package generics.ex19;

import net.mindview.util.Generator;

import java.util.ArrayList;
import java.util.Random;

import generics.ex13.Generators;

/**
 * @author wangzhichao
 * @since 2019/12/18
 */
class Item {
    private final int id;
    private String description;
    private String destination;
    private double price;

    public Item(int id, String description, String destination, double price) {
        this.id = id;
        this.description = description;
        this.destination = destination;
        this.price = price;
    }

    public void priceChange(double change) {
        price += change;
    }

    @Override
    public String toString() {
        return id + ", " + description + ", " + destination + ", " + price;
    }

    public static Generator<Item> generator =
            new Generator<Item>() {
                private Random random = new Random(47);

                @Override
                public Item next() {
                    return new Item(random.nextInt(1000), "Item", "Shanghai",
                            Math.round(random.nextDouble()) * 1000.0D + 0.99D);
                }
            };
}

class Shelf extends ArrayList<Item> {
    public Shelf(int nItems) {
        Generators.fill(this, Item.generator, nItems);
    }
}

class StorageArea extends ArrayList<Shelf> {
    public StorageArea(int nShelves, int nItems) {
        for (int i = 0; i < nShelves; i++) {
            add(new Shelf(nItems));
        }
    }
}

class Deck extends ArrayList<StorageArea> {
    public Deck(int nStorageAreas, int nShelves, int nItems) {
        for (int i = 0; i < nStorageAreas; i++) {
            add(new StorageArea(nShelves, nItems));
        }
    }
}

public class CargoShip extends ArrayList<Deck> {
    public CargoShip(int nDecks, int nStorageAreas, int nShelves, int nItems) {
        for (int i = 0; i < nDecks; i++) {
            add(new Deck(nStorageAreas, nShelves, nItems));
        }
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (Deck deck : this) {
            for (StorageArea storageArea : deck) {
                for (Shelf shelf : storageArea) {
                    for (Item item : shelf) {
                        result.append(item);
                        result.append("\n");
                    }
                }
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(new CargoShip(3, 5, 10, 5));
    }
}
