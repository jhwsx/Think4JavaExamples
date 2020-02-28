package strings.ex04;

import java.util.Formatter;

/**
 * @author wangzhichao
 * @date 2019/09/07
 */
public class Receipt {
    private double total = 0;
    private static final int ITEM_COLUMN_WIDTH = 15;
    private static final int ITEM_QTY_WIDTH = 5;
    private static final int ITEM_PRICE_WIDTH = 10;
    private final String format2 = "%-" + ITEM_COLUMN_WIDTH + ".15s %" + ITEM_QTY_WIDTH + "d %" + ITEM_PRICE_WIDTH + ".2f\n";
    private final String format1 = "%-" + ITEM_COLUMN_WIDTH + "s %" + ITEM_QTY_WIDTH + "s %" + ITEM_PRICE_WIDTH + "s\n";
    private Formatter f = new Formatter(System.out);
    private final String format3 = "%-" + ITEM_COLUMN_WIDTH + "s %" + ITEM_QTY_WIDTH + "s %" + ITEM_PRICE_WIDTH + ".2f\n";

    public void printTitle() {
        f.format(format1, "Item", "Qty", "Price"); // -代表改变对齐方向，默认是右对齐的
        f.format(format1, "----", "---", "-----");
    }

    public void print(String name, int qty, double price) {
        f.format(format2, name, qty, price); // .15 代表打印 String 的最大长度；.2 代表精确度
        total += price;
    }

    public void printTotal() {
        f.format(format3, "Tax", "", total * 0.06);
        f.format(format1, "", "", "-----");
        f.format(format3, "Total", "", total * 1.06);
    }

    public static void main(String[] args) {
        Receipt receipt = new Receipt();
        receipt.printTitle();
        receipt.print("Jack's Magic Beans", 4, 4.25);
        receipt.print("Princess Peas", 3, 5.1);
        receipt.print("Three Bears Porridge", 1, 14.29);
        receipt.printTotal();
    }
}
