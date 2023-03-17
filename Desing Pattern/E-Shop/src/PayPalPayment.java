public class PayPalPayment implements IPayment {
    private String email;
    private String password;
    private double balance;


    public PayPalPayment(String email, String password) {
        this.email = email;
        this.password = password;
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
