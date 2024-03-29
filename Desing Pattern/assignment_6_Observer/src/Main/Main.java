package Main;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {

        ConcreteSubject concreteSubject = new ConcreteSubject("src/Files");
        concreteSubject.registerObserver(new ConcreteObserver("Observer 1"));
        concreteSubject.registerObserver(new ConcreteObserver("Observer 2"));
        concreteSubject.trackFileChanges();

        // Input:
        // I renamed a file form the directory

        // Output:
        // Observer 1 => Entry was DELETED on log dir.:test5.txt
        // Observer 2 => Entry was DELETED on log dir.:test5.txt
        // Observer 1 => Entry was CREATED on log dir.:test7.txt
        // Observer 2 => Entry was CREATED on log dir.:test7.txt

    }
}
