import java.util.Scanner;

public class PayWithCrypto implements IPaymentStrategy{
    
    CryptocurrencyPayment cryptocurrency;

    @Override
    public boolean checkPaymentMethod(String paymentMethod) {
        return paymentMethod.equalsIgnoreCase("crc");
    }

    @Override
    public double transaction(double discount, double checkOutAmount) {

        double remainingBalance = 0;

        while(true){
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter Waller Address: ");
            String walletAddress = scanner.next();
            System.out.println("Enter Secret Key: ");
            String secretKey = scanner.next();

            cryptocurrency = new CryptocurrencyPayment(walletAddress, secretKey);

            if (cryptocurrency.checkCredentials()) {
                remainingBalance = cryptocurrency.pay(discount, checkOutAmount);

                System.out.println("Remaining Balance: " + remainingBalance);
                return remainingBalance;
            } else {
                System.out.println("Wrong Card Credentials, please try again...");
            }
        }
    }
}
