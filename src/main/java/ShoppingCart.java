import java.util.ArrayList;

public class ShoppingCart {
    private final ArrayList<Good> goods = new ArrayList<>();
    private double total = 0.0;

    public boolean addGoodAtCart(Good good) {
        boolean isAdd = goods.add(good);
        if (isAdd) {
            total += good.getCost();
        }
        return isAdd;
    }

    public void printCart() {
        for (Good good : goods) {
            System.out.println(good);
        }
    }

    public double getTotal() {
        return total;
    }
}
