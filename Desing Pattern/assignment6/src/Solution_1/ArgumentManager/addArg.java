package Solution_1.ArgumentManager;

import Solution_1.Constants.constants;
import Solution_1.Main.CLI;
import Solution_1.xmlParser.DatabaseFile;

public class addArg implements ArgStrategy{
    @Override
    public boolean match(String arg) {
        return arg.equals("add");
    }

    @Override
    public void executeCMD(String inputCMD) {
        String[] cmdArgs = inputCMD.split("");

        DatabaseFile currentDb = CLI.getDatabaseFile();
        if (currentDb != null) {
            currentDb.addData(cmdArgs[1]);
        } else {
            System.out.println(constants.NO_DATABASE_SELECTED);
        }
    }
}
