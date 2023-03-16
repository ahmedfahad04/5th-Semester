public class PayWithCrypto implements IPaymentStrategy{
    
    CryptocurrencyPayment cryptocurrency;
    double totalPrice;

    @Override
    public boolean checkPaymentMethod(IPayment paymentMethod) {
        cryptocurrency = (CryptocurrencyPayment) paymentMethod;
        return paymentMethod instanceof CryptocurrencyPayment;
    }

    @Override
    public double transaction(Product product) {

        double productPrice = product.getPrice();

        if (cryptocurrency.checkCredentials()) {
            totalPrice = cryptocurrency.pay(productPrice);
            product.setInventory(product.getInventory() - 1);

        } else {
            totalPrice = -1;
            // TODO: Issue a warning to the user that the payment was not successful
        }

        return totalPrice;
    }
}
