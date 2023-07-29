package Solution_1.ArgumentManager;

import Solution_1.Main.CLI;
import Solution_1.Constants.constants;
import Solution_1.xmlParser.DatabaseFile;
import Solution_1.xmlParser.RegistryFile;

public class useArg implements ArgStrategy{
    @Override
    public boolean match(String arg) {
        return arg.equals("use");
    }

    @Override
    public void executeCMD(String inputCMD) {

        String[] cmdArgs = inputCMD.split(" ");
        RegistryFile registry = RegistryFile.getInstance(constants.DATA_XML_PATH);
        String path = registry.getDatabasePath(cmdArgs[1], false);
        DatabaseFile currentDb;

        if (path != null) {
            currentDb = new DatabaseFile(path);
            currentDb.EditMode();

            CLI.setDatabase(currentDb);
            System.out.println("Successfully loaded Database named: " + cmdArgs[1]);
        } else {
            System.out.println("Database not found");
        }
    }
}
