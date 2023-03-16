public interface IPayment {
    double pay(double amount);
    double applyDiscount(double totalPrice);
    boolean checkCredentials();
}
