import java.util.Scanner;

public class PayWithPayPal implements IPaymentStrategy{
    
    PayPalPayment paypal;

    @Override
    public boolean checkPaymentMethod(String paymentMethod) {
        return paymentMethod.equalsIgnoreCase("pp");
    }

    @Override
    public void transaction(double amount) {

        while(true) {
            Scanner scanner = new Scanner(System.in);

            System.out.println("Enter Email Address: ");
            String email = scanner.nextLine();
            System.out.println("Enter Password: ");
            String password = scanner.nextLine();

            paypal = new PayPalPayment(email, password);

            if (paypal.checkCredentials()) {
                System.out.println("Remaining Balance: " + paypal.pay(amount));
                break;
            } else {
                System.out.println("Wrong Card Credentials, please try again...");
            }
        }
    }

}
