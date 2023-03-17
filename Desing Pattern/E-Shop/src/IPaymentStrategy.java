public interface IPaymentStrategy {

    public boolean checkPaymentMethod(String paymentMethod);

    public double transaction(double amount, double checkOutAmount);

}
