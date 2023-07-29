package com.factory_pattern;


import javax.swing.plaf.basic.BasicBorders;

public class Main {
    public static void main(String[] args) {

        // here Button is the abstract class
        // where the factory methods are setStyle()
        // and setEffect() which are implemented
        // in the subclasses FlatButton and RaisedButton
        // and the subclasses are instantiated here

        Widget flatButton = new FlatButton("Button1");
        Button button = flatButton.RenderButton();
        button.showDetails();
    }
}
