package classwork;

public class Main {
    public static void main(String[] args) {
        ConcreteSubject concreteSubject = new ConcreteSubject();
        concreteSubject.registerObserver(new ConcreteObserver("Observer 1"));
        concreteSubject.registerObserver(new ConcreteObserver("Observer 2"));
    }

}
