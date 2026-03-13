package activityPrograms;

public class BankAccount {
private Integer balance;

    // Constructor
    public BankAccount(Integer initialBalance) {
        balance = initialBalance;
    }

    // Method to withdraw money
    public Integer withdraw(Integer amount) {
        if (balance < amount) {
            throw new NotEnoughFundsException(amount, balance);
        }
        balance -= amount;
        return balance;
    }
}
