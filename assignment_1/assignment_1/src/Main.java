//  Explanation:  We need to make interface because the relation between rectangle might be an 'is-a'
//  relation for Square, but they are not actually an "is substitution of" relation between them.
//  We could call them replaceable when both of them have same methods or behaviors, but here,
//  we observe a contrast in case of their height, width.
//
//  Therefore, we should create an abstraction for the behaviors that are common and expected to
//  contain each of its implementation. That's why we have added the common functionality in
//  an Interface and other's functionalities are class specific.
//
//  Thus using Interface, we can resolve the LSP Violation.

interface Shape {

    double calculateArea();
    void setTopLeft(double x, double y);
    void draw();

}

class Square implements Shape {

    double side;

    public Square(double side) {
        this.side = side;
    }

    void setSize(double s) {
        this.side = s;
    }

    @Override
    public double calculateArea() {
        System.out.print("Square Area: ");
        return side * side;
    }

    @Override
    public void setTopLeft(double x, double y) {
        // implementation
    }

    @Override
    public void draw() {
        System.out.print("Square - ");
    }
}

class Rectangle implements Shape {
    double width;
    double height;

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    public void setSize(double w, double h) {
        this.width = w;
        this.height = h;
    }

    @Override
    public double calculateArea() {
        System.out.print("Rectangle Area: ");
        return width * height;
    }

    @Override
    public void setTopLeft(double x, double y) {
        // implementation
    }

    @Override
    public void draw() {
        // implementation
    }
}

class AreaCalculator {
    public void calculateArea(Shape s) {
        System.out.println(s.calculateArea());
    }
}


public class Main {
    public static void main(String[] args) {
        Rectangle rectangle = new Rectangle(10, 20);
        Square square = new Square(20);
        AreaCalculator areaCalculator = new AreaCalculator();
        Shape recShape = new Rectangle(2,2);
        Shape squareShape = new Square(5);

        rectangle.setSize(10, 25);
        square.setSize(25);

        areaCalculator.calculateArea(rectangle);
        areaCalculator.calculateArea(square);

        System.out.println(recShape.calculateArea());
        System.out.println(squareShape.calculateArea());

        // We can't change the size of each shape through recShape/squareShape because
        // size property is specific for each kind of Shape,  it's not same for all
        // however we can relate a Rhombus with Square, Parallelogram with Rectangle
        // as in terms of SIZE, these pairs are similar/substitutable.

    }
}