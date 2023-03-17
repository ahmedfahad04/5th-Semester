public class CreditCardPayment implements IPayment {
    private String cardNumber;
    private String cardholderName;
    private double balance;

    public CreditCardPayment(String cardNumber, String phoneNumber) {
        this.cardNumber = cardNumber;
        this.cardholderName = phoneNumber;
    }

    @Override
    public double pay(double amount) {
        if (amount < balance) {
            balance -= amount;
        } else {
            System.out.println("Insufficient funds");
        }
        return balance;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public double applyDiscount(double totalPrice) {
        return 0.0;
    }

    @Override
    public boolean checkCredentials() {
        return true;
    }
}
