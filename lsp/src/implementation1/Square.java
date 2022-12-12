package implementation1;

import implementation2.rectangle;

public class Square extends rectangle {

    double side;

    public Square(double side){
        super(side, side);
    }

    void setSize(double s) {
        super.setSize(s, s);
    }
}
