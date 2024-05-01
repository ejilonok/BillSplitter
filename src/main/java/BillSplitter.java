public class BillSplitter {
    private final int friendCount;
    private final ShoppingCart cart;
    private double[] parts = null;

    public BillSplitter(int friendCount, ShoppingCart cart) {
        this.friendCount = friendCount;
        this.cart = cart;
    }

    public void split() {
        parts = new double[friendCount];
        double total = cart.getTotal();
        double costPart = CostUtils.costFloorToKop( total / (double) friendCount );

        total = total - costPart * friendCount;
        for (int i = 0; i < friendCount; i++) {
            parts[i] = costPart;
            /* Проверяем, что остаток от распределения меньше копейки.
            Так как мы хранили данные в double существует ошибка представления данных и разница
             должна быть меньше копейки. */
            if ( total >= 0.01) {
                parts[i] += 0.01;
                total -= 0.01;
            }
        }
    }

    public double getPart(int index) {
        if ((parts == null) || (index >= friendCount) || (index < 0)) {
            return 0.0;
        } else {
            return parts[index];
        }
    }

    public int getFriendCount() {
        return friendCount;
    }
}
