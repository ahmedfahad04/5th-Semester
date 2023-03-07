package Solution_1.Main;

import java.util.Scanner;
import Solution_1.Constants.*;
import static Solution_1.Main.CLI.clientInput;


public class Main {
    public static void main(String[] args) {

        System.out.println(constants.HEADING);
        Scanner input = new Scanner(System.in);

        while (true) {
            System.out.print(constants.CMD_PREFIX);
            String currentCmd = input.nextLine();

            // break if user wants to exit
            if (currentCmd.equals("exit;")) {
                break;
            }

            long startTime = System.nanoTime();
            clientInput(currentCmd);
            long endTime = System.nanoTime();

            long exeTime = (endTime - startTime) / 1000000;
            System.out.println("\nExecution Time: " + exeTime + "ms");
        }

        input.close();
    }

}
