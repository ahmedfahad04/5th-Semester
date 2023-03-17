import java.util.Scanner;

public class PayWithPayPal implements IPaymentStrategy{
    
    PayPalPayment paypal;

    @Override
    public boolean checkPaymentMethod(String paymentMethod) {
        return paymentMethod.equalsIgnoreCase("pp");
    }

    @Override
    public double transaction(double discount, double checkOutAmount) {

        double remainingBalance = 0;

        while(true) {
            Scanner scanner = new Scanner(System.in);

            System.out.println("Enter Email Address: ");
            String email = scanner.nextLine();
            System.out.println("Enter Password: ");
            String password = scanner.nextLine();

            paypal = new PayPalPayment(email, password);

            if (paypal.checkCredentials()) {
                remainingBalance = paypal.pay(discount, checkOutAmount);
                System.out.println("Remaining Balance: " + remainingBalance);
                return remainingBalance;
            } else {
                System.out.println("Wrong Card Credentials, please try again...");
            }
        }
    }

}
