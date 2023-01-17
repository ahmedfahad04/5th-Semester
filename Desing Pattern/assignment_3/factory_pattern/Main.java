package com.factory_pattern;


public class Main {
    public static void main(String[] args) {

        // here Button is the abstract class
        // where the factory methods are setStyle()
        // and setEffect() which are implemented
        // in the subclasses FlatButton and RaisedButton
        // and the subclasses are instantiated here
        Button button = new FlatButton("MyButton1");
        Button button2 = new RaisedButton("MyButton2");
        System.out.printf(button2.btnlbl);
    }
}
