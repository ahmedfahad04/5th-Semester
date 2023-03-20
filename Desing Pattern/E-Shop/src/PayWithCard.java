import java.util.Scanner;

public class PayWithCard implements IPaymentStrategy {
    CreditCardPayment creditCard;

    @Override
    public boolean checkPaymentMethod(String paymentMethod) {
        return paymentMethod.equalsIgnoreCase("cc");
    }

    @Override
    public double transaction(double discount, double checkOutAmount) {

        double remainingBalance = 0;

        while(true) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter " + Constants.GREEN +  "Card Number: " + Constants.RESET);
            String cardNumber = scanner.nextLine();
            System.out.print("Enter " + Constants.GREEN +  "Phone Number: " + Constants.RESET);
            String phoneNumber = scanner.nextLine();

            creditCard = new CreditCardPayment(cardNumber, phoneNumber);

            if (creditCard.checkCredentials()) {
                remainingBalance = creditCard.pay(discount, checkOutAmount);
                System.out.println("Remaining Balance: " + remainingBalance);

                return remainingBalance;
            } else {
                System.out.println("Wrong Card Credentials, please try again...");
            }
        }

    }
}
