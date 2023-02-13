package Solution_1.ArgumentManager;

import Solution_1.Constants.constants;
import Solution_1.Main.CLI;
import Solution_1.xmlParser.DatabaseFile;

public class readArg implements ArgStrategy{
    @Override
    public boolean match(String arg) {
        return arg.equals("read");
    }

    @Override
    public void executeCMD(String inputCMD) {
        String[] cmdArgs = inputCMD.split("");

        DatabaseFile currentDb = CLI.getDatabaseFile();
        if (currentDb != null) {
            if (cmdArgs.length == 1) {
                currentDb.readData();
            } else {
                currentDb.readData(cmdArgs[1]);
            }
        } else {
            System.out.println(constants.NO_DATABASE_SELECTED);
        }
    }
}
