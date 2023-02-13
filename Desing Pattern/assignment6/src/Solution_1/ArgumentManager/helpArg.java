package Solution_1.ArgumentManager;

import Solution_1.Constants.constants;

public class helpArg implements ArgStrategy{
    @Override
    public boolean match(String arg) {
        return arg.equals("help");
    }

    @Override
    public void executeCMD(String inputCMD) {
        System.out.println(constants.HELP_COMMANDS);
    }
}
