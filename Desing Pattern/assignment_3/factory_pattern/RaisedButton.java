package com.factory_pattern;

public class RaisedButton extends Button{
    public RaisedButton(String buttonLable) {
        super(buttonLable);
    }

    @Override
    public StyleSheet setStyle() {
        return new RaisedStyle();
    }

    @Override
    public GraphicEffect setEffect() {
        return new BoxEffect();
    }
}
