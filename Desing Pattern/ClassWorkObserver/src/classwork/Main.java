package classwork;

import java.io.IOException;

public class Main {

    // Need to add file properties.

    public static void main(String[] args) throws IOException, InterruptedException {

        ConcreteSubject concreteSubject = new ConcreteSubject("src/Files");
        concreteSubject.registerObserver(new ConcreteObserver("Observer 1"));
        concreteSubject.registerObserver(new ConcreteObserver("Observer 2"));
        concreteSubject.trackFileChanges();

        // Input:
        // We delete a file form the directory

        // Output:
        // Observer 1 => Entry was DELETED on log dir.:test5.txt
        // Observer 2 => Entry was DELETED on log dir.:test5.txt
        // Observer 1 => Entry was CREATED on log dir.:test7.txt
        // Observer 2 => Entry was CREATED on log dir.:test7.txt

    }
}
