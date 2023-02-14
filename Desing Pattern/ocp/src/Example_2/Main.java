package Example_2;

public class Main {
    public static void main(String[] args) {

        /*
         * In case of Open Close Principal, just avoid if-else or switch-case
         * statements. Instead of that, use polymorphism.
         ! Make "separate class for each new addition" of features and extends the
         ! common methods from the parent class.
         */
        
        Calculator calculator = new Calculator();
        CalculatorOperation add = new Addition(10, 20);
        CalculatorOperation subtract = new Substraction(25,30);
        CalculatorOperation multiply = new Multiplication(5, 7);
        CalculatorOperation divide = new Division(10,2);

        calculator.calculate(add);
        calculator.calculate(subtract);
        calculator.calculate(multiply);
        calculator.calculate(divide);
    }
}
