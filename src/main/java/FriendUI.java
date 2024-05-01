import java.util.Scanner;
public class FriendUI {
    public static int getFriendCount(Scanner sc) {
        int friendCount;
        TextUiUtils.showText("Пожалуйста, введите число гостей, на которых разделить счет: ");
        String input;
        while (true) {
            try {
                input = sc.nextLine();
                friendCount = Integer.parseInt(input);
                if (friendCount == 1) {
                    TextUiUtils.showText("Вы ввели 1 гостя. Нет необходимости делить товары. Введите другое число гостей:");
                } else if (friendCount < 1) {
                    TextUiUtils.showText("Кажется, вы случайно щелкнули на клавиатуре не туда. Число оказалось меньше 1. Введите другое число гостей:");
                } else {
                    TextUiUtils.showText("Все ясно! Будем делить счет на " + friendCount + " гостей");
                    break;
                }
            } catch (NumberFormatException e) {
                TextUiUtils.showText("Некорректный ввод числа. Пожалуйста, повторите ввод числа гостей");
            }
        }
        return friendCount;
    }
}
