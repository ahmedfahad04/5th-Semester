package Main;

public abstract class Observer {

    // represents file monitor

    public Observer(){};

    public abstract void Update(Subject theChangedSubject);

}
