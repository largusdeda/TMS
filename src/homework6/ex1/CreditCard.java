package homework6.ex1;

/**
 * @author Elena Chinarina
 *
 **/

public class CreditCard {
    private final String accountNumber;
    private double currentAmount;
    private final double creditLimit;

    public CreditCard(String accountNumber, double initialAmount, double creditLimit) {
        this.accountNumber = accountNumber;
        this.currentAmount = initialAmount;
        this.creditLimit = creditLimit;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            currentAmount += amount;
            System.out.printf("На карту %s начислено %.2f у.е.. ", accountNumber, amount);
            System.out.printf("Текущий баланс: %.2f у.е..\n", currentAmount);
        } else {
            System.out.println("Сумма начисления должна быть положительной.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0) {
            double availableAmount = currentAmount + creditLimit;

            if (amount <= availableAmount) {
                currentAmount -= amount;
                System.out.printf("С карты %s снято %.2f у.е.. ", accountNumber, amount);
                System.out.printf("Текущий баланс: %.2f у.е..", currentAmount);

                if (currentAmount < 0) {
                    System.out.printf(" (Использовано кредитных средств: %.2f у.е. из %.2f у.е.)",
                            -currentAmount, creditLimit);
                }

                System.out.printf("\nДоступно кредитных средств: %.2f у.е..\n", currentAmount + creditLimit);
            } else {
                System.out.println("Превышен кредитный лимит.");
            }
        } else {
            System.out.println("Сумма снятия должна быть положительной.");
        }
    }

    public void displayInfo() {
        System.out.printf("Карта %s: баланс - %.2f у.е..", accountNumber, currentAmount);
        if (currentAmount < 0) {
            System.out.printf(" (Долг: %.2f у.е., доступно кредитных средств: %.2f у.е..)\n",
                    -currentAmount, creditLimit + currentAmount);
        } else {
            System.out.printf(" (Собственные средства: %.2f у.е., доступно кредитных средств: %.2f у.е..)\n",
                    currentAmount, creditLimit + currentAmount);
        }
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public double getCurrentAmount() {
        return currentAmount;
    }

    public double getCreditLimit() {
        return creditLimit;
    }
}
