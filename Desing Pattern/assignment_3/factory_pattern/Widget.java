package com.factory_pattern;

public abstract class Widget {

    public String btnlbl;

    public Widget(String buttonLable) {
        this.btnlbl = buttonLable;
    }


    public Button RenderButton(){
        Button button = new Button();

        StyleSheet style1 = new StyleSheet("Flat");
        StyleSheet style2 = new StyleSheet("Raised");

        button.addStyle(style1);
        button.addStyle(style2);

        return button;
    }

    // factory methods
    public abstract StyleSheet setStyle();

    public abstract GraphicEffect setEffect();

}
