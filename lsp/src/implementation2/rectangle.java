package implementation2;


public class rectangle implements shape {
    double width;
    double height;

    public rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    void setTopLeft(double x, double y) {
        // implementation
    }

    public void setSize(double w, double h) {
        this.width = w;
        this.height = h;
    }


    void draw() {
        // implementation
    }

    @Override
    public double calculateArea() {
        return width*height;
    }
}
