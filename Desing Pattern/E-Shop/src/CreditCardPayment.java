public class CreditCardPayment implements IPayment {
    private String cardNumber;
    private String cardholderName;

    public CreditCardPayment(String cardNumber, String phoneNumber) {
        this.cardNumber = cardNumber;
        this.cardholderName = phoneNumber;
    }

    @Override
    public double pay(double amount) {
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
