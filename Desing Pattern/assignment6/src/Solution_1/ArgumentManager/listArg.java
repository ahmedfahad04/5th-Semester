package Solution_1.ArgumentManager;

import Solution_1.Constants.constants;
import Solution_1.xmlParser.RegistryFile;

public class listArg implements ArgStrategy{
    @Override
    public boolean match(String arg) {
        return arg.equals("list");
    }

    @Override
    public void executeCMD(String inputCMD) {
        RegistryFile registry = RegistryFile.getInstance(constants.DATA_XML_PATH);
        registry.listAllDatabases();
    }
}
