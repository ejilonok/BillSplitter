import java.util.Scanner;
import java.util.ArrayList;

public class UserTextInterface {
    final Scanner sc = new Scanner(System.in);
    ArrayList<Good> goods = new ArrayList<>();
    double total = 0.0;

    public void start() {
        greeting();
        int friendCount = getFriendCount();

        printMenu();
        String command = sc.nextLine();
        while ( !command.trim().equalsIgnoreCase("Завершить") ) {
            String name = getGoodName();
            double cost = getGoodCost();

            addNewGood(name, cost);
            total += cost;

            printMenu();
            command = sc.nextLine();
        }

        printTotal(friendCount);

        printGoodBye();
    }

    void greeting() {
        System.out.println("\tДобро пожаловать в программу разделения счета!");
        System.out.println("Данная программа предназначена для ввода числа гостей и списка заказанных товаров или услуг.");
        System.out.println("Когда вы введете полный перечень товаров или услуг, программа автоматически предоставит Вам список и сумму оплаты каждым гостем.");
        System.out.println("-----------------------------------------------");
    }

    int getFriendCount() {
        int friendCount;
        System.out.println("Пожалуйста, введите число гостей, на которых разделить счет: ");
        while (true) {
            friendCount = sc.nextInt();
            if (friendCount == 1) {
                System.out.println("Вы ввели 1 гостя. Нет необходимости делить товары. Введите другое число гостей:");
            } else if (friendCount < 1) {
                System.out.println("Кажется, вы случайно щелкнули на клавиатуре не туда. Число оказалось меньше 1. Введите другое число гостей:");
            } else {
                System.out.println("Все ясно! Будем делить счет на " + friendCount + " гостей");
                break;
            }
        }
        return friendCount;
    }

    void printMenu() {
        System.out.println("Чтобы добавить еще один товар, введите любой символ.");
        System.out.println("Введите 'Завершить', чтобы завершить работу программы.");
        System.out.println("-----------------------------------------------");
    }
    String getGoodName() {
        System.out.println("Введите название добавляемого товара:");
        return sc.nextLine();
    }

    boolean isCostCorrect(String lineinput) {
        boolean isCorr = true;
        double cost;
        try {
            cost = Double.parseDouble( lineinput );
            if (cost < 0.0) {
                System.out.println("Ошибка ввода. Не могу работать с отрицательными стоимостями.");
                isCorr = false;
            } else if (CostUtils.hasKopParts(cost)) {
                System.out.println("Ошибка ввода. Вы ввели дробное число копеек.");
                isCorr = false;
            }
        } catch (NumberFormatException e) {
            isCorr = false;
            System.out.println("Кажется, кто-то воспользовался клавиатурой без вас. Введено не число.");
        }
        return isCorr;
    }
    double getGoodCost() {
        System.out.println("Теперь введите стоимость товара в формате [рубли].[копейки].");
        String input = sc.nextLine();

        while (!isCostCorrect(input)) {
            System.out.println("Повторите ввод стоимости товара:");
            input = sc.nextLine();
        }
        return Double.parseDouble(input);
    }
    void addNewGood(String name, double cost) {
        boolean isAdd = goods.add(new Good(name, cost));
        if (isAdd) {
            System.out.println("В список успешно добавлен товар '" + name + "' стоимостью " + CostUtils.costToString(cost));
        } else {
            System.out.println("Неизвестная ошибка добавления товара. Попробуйте добавить товар еще раз.");
        }
    }
    void printTotal(int friendCount) {
        System.out.println("-----------------------------------------------");
        System.out.println("В настоящее время добавлены следующие товары:\n\n");
        for (Good good : goods) {
            System.out.println(good);
        }
        System.out.println("\n");
        System.out.println("Итого в чеке:\t\t" + CostUtils.costToString(total));
        System.out.println("-----------------------------------------------");

        System.out.println("Предлагаю разделить чек следующим образом:");
        double[] parts = CostUtils.costPart(total, friendCount);
        for (int i = 0; i < friendCount; i++) {
            System.out.println( i + " гость платит   " + CostUtils.costToString(parts[i]));
        }
        System.out.println("-----------------------------------------------");
    }
    private void printGoodBye() {
        System.out.println("Спасибо, что воспользовались программой! Надеюсь, Вы довольны ее работой! До новых встреч ;)");
        System.out.println("Bill splitter ver 0.1\t\tcreated by ejil");
    }
}
