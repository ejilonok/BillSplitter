import java.util.Scanner;

public class UserTextInterface {
    private final Scanner sc = new Scanner(System.in);
    //int friendCount = 1;
    private final ShoppingCart cart = new ShoppingCart();
    int friendCount = 1;
    public void start() {
        greeting();

        friendCount = FriendUI.getFriendCount(sc);

        ShoppingCartUI cartUI = new ShoppingCartUI(cart, sc);
        cartUI.takeCart();
        cartUI.printCart();

        BillSplitter billSplitter = new BillSplitter(friendCount, cart);
        BillSplitterUI billSplitterUI = new BillSplitterUI(billSplitter);

        billSplitterUI.calcAndShow();

        printGoodBye();
    }

    private void greeting() {
        TextUiUtils.showDiv("\tДобро пожаловать в программу разделения счета!\nДанная программа предназначена для ввода числа гостей и списка заказанных товаров или услуг.\nКогда вы введете полный перечень товаров или услуг, программа автоматически предоставит Вам список и сумму оплаты каждым гостем.");
    }

    private void printGoodBye() {
        TextUiUtils.showDiv("Спасибо, что воспользовались программой! Надеюсь, Вы довольны ее работой! До новых встреч ;)\nBill splitter ver 0.2\t\tcreated by ejil");
    }
}
