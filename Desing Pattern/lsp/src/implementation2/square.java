package implementation2;

public class square implements shape {

    double side;

    public square(double side){
        this.side = side;
    }

    void setSize(double s) {
        this.side = s;
    }

    @Override
    public double calculateArea() {
        return side*side;
    }
}
