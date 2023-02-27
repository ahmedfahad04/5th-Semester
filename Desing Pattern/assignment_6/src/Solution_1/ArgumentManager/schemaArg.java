package Solution_1.ArgumentManager;

import Solution_1.Constants.constants;
import Solution_1.Main.CLI;
import Solution_1.xmlParser.DatabaseFile;

public class schemaArg implements ArgStrategy{
    @Override
    public boolean match(String arg) {
        return arg.equals("schema");
    }

    @Override
    public void executeCMD(String inputCMD) {
        String[] cmdArgs = inputCMD.split(" ");

        DatabaseFile currentDb = CLI.getDatabaseFile();

        if (currentDb != null) {
            String xy = cmdArgs[1];

            if (xy.equals("show")) {
                System.out.println(currentDb.getSchema());
            } else {
                String[] schemaVals = xy.split(",");
                if (schemaVals.length > 1) {
                    currentDb.createSchema(xy);
                } else {
                    System.out.println("There should be at least 2 columns of data");
                }
            }

        } else {
            System.out.println(constants.NO_DATABASE_SELECTED);
        }
    }
}
