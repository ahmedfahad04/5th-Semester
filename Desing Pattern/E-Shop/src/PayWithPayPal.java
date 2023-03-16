public class PayWithPayPal implements IPaymentStrategy{
    
    PayPalPayment paypal;
    double totalPrice;

    @Override
    public boolean checkPaymentMethod(IPayment paymentMethod) {
        paypal = (PayPalPayment) paymentMethod;
        return paymentMethod instanceof PayPalPayment;
    }

    @Override
    public double transaction(Product product) {

        double productPrice = product.getPrice();

        if (paypal.checkCredentials()) {
            
            totalPrice = paypal.pay(productPrice);
            product.setInventory(product.getInventory() - 1);

        } else {
            totalPrice = -1;
            // TODO: Issue a warning to the user that the payment was not successful
        }

        return totalPrice;
    }
}
