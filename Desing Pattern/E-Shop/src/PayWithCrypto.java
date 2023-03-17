import java.util.Scanner;

public class PayWithCrypto implements IPaymentStrategy{
    
    CryptocurrencyPayment cryptocurrency;

    @Override
    public boolean checkPaymentMethod(String paymentMethod) {
        return paymentMethod.equalsIgnoreCase("crc");
    }

    @Override
    public void transaction(double amount) {

        while(true){
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter Waller Address: ");
            String walletAddress = scanner.next();
            System.out.println("Enter Secret Key: ");
            String secretKey = scanner.next();

            cryptocurrency = new CryptocurrencyPayment(walletAddress, secretKey);

            if (cryptocurrency.checkCredentials()) {
                System.out.println("Remaining Balance: " + cryptocurrency.pay(amount));
                break;
            } else {
                System.out.println("Wrong Card Credentials, please try again...");
            }
        }
    }
}
