package implementation1;

public class Main {
    public static void main(String[] args) {

        Rectangle r = new Rectangle(10,20);
        r.setSize(10,10);
        System.out.println("Rectangle area is: "+ r.getArea());

        Square s = new Square(20);
        s.setSize(30);
        System.out.println("Square area is: "+ s.getArea());

        Shape r1 = new Rectangle(10,20);
//        r1.setSize(10, 10);   // here goes the error
        System.out.println("Shape(Rectangle) area is: "+ r1.getArea());

//        Shape s1 = new Square(20); // here goes the error
//        s1.setSize(); // here goes the error.
//        System.out.println("Shape(Square) area is: "+ s1.getArea());

    }
}