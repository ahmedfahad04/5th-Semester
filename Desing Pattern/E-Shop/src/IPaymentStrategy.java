public interface IPaymentStrategy {

    public boolean checkPaymentMethod(IPayment paymentMethod);

    public double transaction(Product product);

}
