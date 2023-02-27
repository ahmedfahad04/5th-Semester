package Solution_1.ArgumentManager;

public interface ArgStrategy {

    boolean match(String arg);
    void executeCMD(String inputCMD);
}
