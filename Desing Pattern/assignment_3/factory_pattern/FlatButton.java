package com.factory_pattern;
public class FlatButton extends Widget {

    public FlatButton(String buttonLable) {
        super(buttonLable);
    }

    @Override
    public StyleSheet setStyle() {
        return new FlatStyle("Flat");
    }

    @Override
    public GraphicEffect setEffect() {
        return new BlurEffect();
    }
}
