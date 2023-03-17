import java.util.Scanner;

public class PayWithCard implements IPaymentStrategy {
    CreditCardPayment creditCard;

    @Override
    public boolean checkPaymentMethod(String paymentMethod) {
        return paymentMethod.equalsIgnoreCase("cc");
    }

    @Override
    public double transaction(double discount, double checkOutAmount) {

        double remaininBalance = 0;

        while(true) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter " + Constants.GREEN +  "Card Number:");
            String cardNumber = scanner.nextLine();
            System.out.print("Enter " + Constants.GREEN +  "Phone Number:");
            String phoneNumber = scanner.nextLine();

            creditCard = new CreditCardPayment(cardNumber, phoneNumber);

            if (creditCard.checkCredentials()) {
                remaininBalance = creditCard.pay(discount, checkOutAmount);
                System.out.println("Remaining Balance: " + remaininBalance);
                return remaininBalance;
            } else {
                System.out.println("Wrong Card Credentials, please try again...");
            }
        }

    }
}
