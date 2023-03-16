public class CryptocurrencyPayment implements IPayment {
    private String walletAddress;
    private String secretKey;

    public CryptocurrencyPayment(String walletAddress, String secretKey) {
        this.walletAddress = walletAddress;
        this.secretKey = secretKey;
    }

    @Override
    public double pay(double amount) {
        // process cryptocurrency payment
        return 0.0;
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
