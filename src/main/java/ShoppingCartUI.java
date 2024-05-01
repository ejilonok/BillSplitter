import java.util.Scanner;

public class ShoppingCartUI {
    ShoppingCart cart;
    Scanner sc;

    ShoppingCartUI(ShoppingCart cart, Scanner sc) {
        this.cart = cart;
        this.sc = sc;
    }

    public void takeCart() {
        String command = "";
        printGoodInstruction();
        while ( !command.trim().equalsIgnoreCase("Завершить") ) {
            String name = getGoodName();
            double cost = getGoodCost();

            addNewGood(name, cost);

            printGoodInstruction();
            command = sc.nextLine();
        }
    }
    private void printGoodInstruction() {
        TextUiUtils.showDiv("Чтобы добавить еще один товар, введите любой символ.\nВведите 'Завершить', чтобы завершить работу программы.");
    }

    private String getGoodName() {
        TextUiUtils.showText("Введите название добавляемого товара:");
        return sc.nextLine();
    }

    private boolean isCostCorrect(String lineinput) {
        boolean isCorr = true;
        double cost;
        try {
            cost = Double.parseDouble( lineinput );
            if (cost < 0.0) {
                TextUiUtils.showText("Ошибка ввода. Не могу работать с отрицательными стоимостями.");
                isCorr = false;
            } else if (CostUtils.hasKopParts(cost)) {
                TextUiUtils.showText("Ошибка ввода. Вы ввели дробное число копеек.");
                isCorr = false;
            }
        } catch (NumberFormatException e) {
            isCorr = false;
            TextUiUtils.showText("Кажется, кто-то воспользовался клавиатурой без вас. Введено не число.");
        }
        return isCorr;
    }
    private double getGoodCost() {
        TextUiUtils.showText("Теперь введите стоимость товара в формате [рубли].[копейки].");
        String input = sc.nextLine();

        while (!isCostCorrect(input)) {
            TextUiUtils.showText("Повторите ввод стоимости товара:");
            input = sc.nextLine();
        }
        return Double.parseDouble(input);
    }
    private void addNewGood(String name, double cost) {
        boolean isAdd = cart.addGoodAtCart(new Good(name, cost));
        if (isAdd) {
            TextUiUtils.showText("В список успешно добавлен товар '" + name + "' стоимостью " + CostUtils.costToString(cost));
        } else {
            TextUiUtils.showText("Неизвестная ошибка добавления товара. Попробуйте добавить товар еще раз.");
        }
    }

    public void printCart() {
        TextUiUtils.showText("Спасибо. Ввод товаров успешно завершен.\nВ настоящее время добавлены следующие товары:\n\n");
        cart.printCart();
        TextUiUtils.showDiv("\nИтого в чеке:\t\t" + CostUtils.costToString(cart.getTotal()));
    }
}
