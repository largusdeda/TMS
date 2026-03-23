package homework6.ex1;

/**
 * @author Elena Chinarina
 *
 **/

public class Main {
    public static void main(String[] args) {
        CreditCard card1 = new CreditCard("1234 5678 9012 3456", 1000.00, 5000.00);
        CreditCard card2 = new CreditCard("0987 6543 2109 8765", 500.55, 1000.00);
        CreditCard card3 = new CreditCard("6666 6666 9999 9999", 10056.78, 10000.00);

        System.out.println("-- Исходное состояние карт --");
        card1.displayInfo();
        card2.displayInfo();
        card3.displayInfo();

        System.out.println("\n-- Операции --");

        System.out.println("- Первая карта -");
        card1.deposit(500.00);

        System.out.println("\n- Вторая карта -");
        card2.deposit(250.25);

        System.out.println("\n- Третья карта -");
        card3.withdraw(670.00);

        System.out.println("\n-- Работа кредитного лимита --");

        CreditCard card4 = new CreditCard("1111 2222 3333 4444", 100.00, 5000.00);
        System.out.println("-- Исходное состояние карты --");
        card4.displayInfo();

        System.out.println("\n- Уход в минус -");
        card4.withdraw(200.00);

        System.out.println("\n- Проверка лимита -");
        card4.withdraw(4900.00);

        System.out.println("\n- Проверка лимита -");
        card4.withdraw(100.00);

        System.out.println("\n- Пополнение карты -");
        card4.deposit(300.00);

        System.out.println("\n -- Итоговое состояние --");
        card4.displayInfo();
    }
}
