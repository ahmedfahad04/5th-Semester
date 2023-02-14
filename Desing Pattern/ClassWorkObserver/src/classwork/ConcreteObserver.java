package classwork;

public class ConcreteObserver extends Observer{

    String fileName;
    String typeOfChange;
    String timeOfChange;
    String observerName;

    public ConcreteObserver(String observerName) {
        this.observerName = observerName;
    }

    @Override
    public void Update(Subject theChangedSubject) {
        System.out.println(this.observerName + " => " + theChangedSubject.message);
    }
}
