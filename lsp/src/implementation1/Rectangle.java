package implementation1;

import java.awt.*;

public class Rectangle implements Shape {
    double width;
    double height;

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    public Rectangle() {

    }

    public double getArea(){
        return width*height;
    }

    void setTopLeft(double x, double y) {
        // implementation
    }

    public void setSize(double w, double h) {
        this.width = w;
        this.height = h;
    }

    void setColor(Color color){
        // set color implementation
    }

    void draw() {
        // implementation
    }
}
