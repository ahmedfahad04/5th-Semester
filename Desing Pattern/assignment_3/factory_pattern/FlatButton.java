package com.factory_pattern;
public class FlatButton extends Button{

    public FlatButton(String buttonLable) {
        super(buttonLable);
    }

    @Override
    public StyleSheet setStyle() {
        return new FlatStyle();
    }

    @Override
    public GraphicEffect setEffect() {
        return new BlurEffect();
    }
}
