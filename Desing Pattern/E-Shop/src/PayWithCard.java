import java.util.Scanner;

public class PayWithCard implements IPaymentStrategy {
    CreditCardPayment creditCard;

    @Override
    public boolean checkPaymentMethod(String paymentMethod) {
        return paymentMethod.equalsIgnoreCase("cc");
    }

    @Override
    public void transaction(double amount) {

        while(true) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter Card Number:");
            String cardNumber = scanner.nextLine();
            System.out.println("Enter Phone Number:");
            String phoneNumber = scanner.nextLine();

            creditCard = new CreditCardPayment(cardNumber, phoneNumber);

            if (creditCard.checkCredentials()) {
                System.out.println("Remaining Balance: " + creditCard.pay(amount));
                break;
            } else {
                System.out.println("Wrong Card Credentials, please try again...");
            }
        }

    }
}
