public interface IPayment {
    double pay(double discount, double amount);
    boolean checkCredentials();
}
