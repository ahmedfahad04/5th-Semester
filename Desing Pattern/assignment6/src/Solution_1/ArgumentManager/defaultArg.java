package Solution_1.ArgumentManager;

public class defaultArg implements ArgStrategy{
    @Override
    public boolean match(String arg) {
        return arg.equals("default");
    }

    @Override
    public void executeCMD(String inputCMD) {
        String[] cmdArgs = inputCMD.split(" ");
        System.out.println("UNKNOWN COMMAND: " + cmdArgs[0] + "\nType `help;` for commands list");
    }
}
