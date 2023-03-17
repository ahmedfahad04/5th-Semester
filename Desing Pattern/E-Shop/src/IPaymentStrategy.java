public interface IPaymentStrategy {

    public boolean checkPaymentMethod(String paymentMethod);

    public void transaction(double amount);

}
