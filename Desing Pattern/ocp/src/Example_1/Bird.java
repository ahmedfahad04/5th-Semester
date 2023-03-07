package Example_1;

public class Bird implements Flys {
    public Bird() {
        System.out.println("New Bird obj created...");
    }

    @Override
    public void fly() {
        System.out.println("It Flys");
    }

    // i can either implement the core Fly interface
    // I can extend the ItFly class that implement the Fly interface
    // what's the difference?
}
