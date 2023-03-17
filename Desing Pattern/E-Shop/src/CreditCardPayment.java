import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class CreditCardPayment implements IPayment {
    private String cardNumber;
    private String cardholderName;
    private double balance;

    public CreditCardPayment(String cardNumber, String phoneNumber) {
        this.cardNumber = cardNumber;
        this.cardholderName = phoneNumber;
    }

    @Override
    public double pay(double discount, double amount) {

        if (amount < balance) {
            balance -= amount - discount;
        } else {
            return -1;
        }

        this.setBalance(balance);
        return balance;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public boolean checkCredentials() {
        // read data from the file
        try {
            File myObj = new File("paymentInfo.txt");
            Scanner myReader = new Scanner(myObj);

            while (myReader.hasNextLine()) {
                String[] data = myReader.nextLine().split(",");
                if (data[3].equals("cc") && (this.cardNumber.equals(data[0]) && this.cardholderName.equals(data[1]))) {
                    this.balance = Double.parseDouble(data[2]);
                    return true;
                }

            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return false;
    }
}
