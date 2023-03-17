import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class CryptocurrencyPayment implements IPayment {
    private String walletAddress;
    private String secretKey;
    private double balance;

    public CryptocurrencyPayment(String walletAddress, String secretKey) {
        this.walletAddress = walletAddress;
        this.secretKey = secretKey;
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
                if (data[3].equals("crc") && (this.walletAddress.equals(data[0]) && this.secretKey.equals(data[1]))) {
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
