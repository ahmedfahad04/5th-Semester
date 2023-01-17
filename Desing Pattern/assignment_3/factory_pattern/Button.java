package com.factory_pattern;

public abstract class Button {

    public String btnlbl;

    public Button(String buttonLable) {
        this.btnlbl = buttonLable;
    }

    // factory methods
    public abstract StyleSheet setStyle();

    public abstract GraphicEffect setEffect();

}
