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
            System.out.println("Enter " + Constants.GREEN + "Wallet Address: " + Constants.RESET);
            String walletAddress = scanner.next();
            System.out.println("Enter " + Constants.GREEN + "Secret Key: " + Constants.RESET);
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
