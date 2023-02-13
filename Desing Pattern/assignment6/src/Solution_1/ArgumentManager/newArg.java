package Solution_1.ArgumentManager;

import Solution_1.Constants.constants;
import Solution_1.xmlParser.RegistryFile;

public class newArg implements ArgStrategy{
    @Override
    public boolean match(String arg) {
        return arg.equals("new");
    }

    @Override
    public void executeCMD(String inputCMD) {
        String[] cmdArgs = inputCMD.split(" ");

        RegistryFile registry = RegistryFile.getInstance(constants.DATA_XML_PATH);
        registry.createNewDatabase(cmdArgs[1]);
    }
}
