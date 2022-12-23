package implementation2;

public class Main {
    public static void main(String[] args) {
        rectangle r = new rectangle(10,20);
        square ss = new square(20);

        r.setSize(10,25);
        ss.setSize(25);

        areaCalculator calc = new areaCalculator();
        calc.calculateArea(r);
        calc.calculateArea(ss);
    }
}
