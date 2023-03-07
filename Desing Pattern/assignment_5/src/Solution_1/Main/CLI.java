package Solution_1.Main;

import Solution_1.ArgumentManager.*;
import Solution_1.xmlParser.*;
import java.util.List;

/*
    Smell: Switch Case Smell
    resolution: STRATEGY PATTERN
 */

public class CLI {

    static DatabaseFile databaseFile;

    static void clientInput(String input) {

        List <ArgStrategy> strategies = List.of(
                new addArg(),
                new deleteArg(),
                new listArg(),
                new dropArg(),
                new helpArg(),
                new readArg(),
                new schemaArg(),
                new useArg(),
                new newArg()
        );

        String[] cmdArgs = input.split(" ");


        for (ArgStrategy strategy : strategies) {
            if (strategy.match(cmdArgs[0])) {
                strategy.executeCMD(input);
                return;
            }
        }

        System.out.println("UNKNOWN COMMAND: " + cmdArgs[0] + "\nType `help;` for commands list");
    }

    public static void setDatabase(DatabaseFile database) {
        databaseFile = database;
    }

    public static DatabaseFile getDatabaseFile() {
        return databaseFile;
    }
}

