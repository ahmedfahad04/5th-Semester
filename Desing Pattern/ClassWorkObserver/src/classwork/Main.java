package classwork;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {

        ConcreteSubject concreteSubject = new ConcreteSubject("src/Files");
        concreteSubject.registerObserver(new ConcreteObserver("Observer 1"));
        concreteSubject.registerObserver(new ConcreteObserver("Observer 2"));
        concreteSubject.monitorFileChanges();

    }
}
