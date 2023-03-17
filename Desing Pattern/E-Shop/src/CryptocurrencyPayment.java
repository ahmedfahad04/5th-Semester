public class CryptocurrencyPayment implements IPayment {
    private String walletAddress;
    private String secretKey;
    private double balance;

    public CryptocurrencyPayment(String walletAddress, String secretKey) {
        this.walletAddress = walletAddress;
        this.secretKey = secretKey;
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
