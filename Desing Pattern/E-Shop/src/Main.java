import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


        Faraz farazStore = new Faraz();
        System.out.println(Constants.HEADING);
        Scanner input = new Scanner(System.in);

        label:
        while (true) {
            System.out.println(Constants.HELP_COMMANDS);
            System.out.print(Constants.CMD_PREFIX);
            String currentCmd = input.next();

            if (currentCmd.equalsIgnoreCase("exit")) {
                break;
            }

            // break if user wants to exit
            switch (currentCmd) {
                case "1" -> farazStore.shop();
                case "2" -> farazStore.addNewProduct();
                default -> {
                }
            }
        }
    }
}
