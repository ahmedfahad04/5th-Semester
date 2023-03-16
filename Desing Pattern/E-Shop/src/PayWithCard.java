public class PayWithCard implements IPaymentStrategy {
    CreditCardPayment creditCard;
    double totalPrice;

    @Override
    public boolean checkPaymentMethod(IPayment paymentMethod) {
        creditCard = (CreditCardPayment) paymentMethod;
        return paymentMethod instanceof CreditCardPayment;
    }

    @Override
    public double transaction(Product product) {

        double productPrice = product.getPrice();

        if (creditCard.checkCredentials()) {
            totalPrice = creditCard.pay(productPrice);
            product.setInventory(product.getInventory() - 1);

        } else {
            totalPrice = -1;
            // TODO: Issue a warning to the user that the payment was not successful
        }

        return totalPrice;
    }
}
