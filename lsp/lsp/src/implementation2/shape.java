package implementation2;

public interface shape {

    // we need to make interface because the relation between rectangle might be an 'is-a'
    // relation for Square, but they are not actually an "is substitution of" relation
    // among them.

    // we should create an abstraction for the behaviors that are common or expected to
    // contain each of it's implementation

    double calculateArea();

}
