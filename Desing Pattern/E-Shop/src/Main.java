import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {


        Faraz farazStore = new Faraz();
        System.out.println(Constants.HEADING);
        Scanner input = new Scanner(System.in);

        while (true) {
            System.out.println(Constants.HELP_COMMANDS);
            System.out.print(Constants.CMD_PREFIX);
            String currentCmd = input.next();

            if (currentCmd.equalsIgnoreCase("exit")) {
                break;
            }

            // options are limited. That's why we used switch statement
            switch (currentCmd) {
                case "1" -> farazStore.shop();
                case "2" -> farazStore.addNewProduct();
                default -> {
                }
            }
        }
    }
}
