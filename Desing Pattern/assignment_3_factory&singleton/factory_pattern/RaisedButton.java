package com.factory_pattern;

public class RaisedButton extends Widget {
    public RaisedButton(String buttonLable) {
        super(buttonLable);
    }

    @Override
    public StyleSheet setStyle() {
        return new RaisedStyle("Raised");
    }

    @Override
    public GraphicEffect setEffect() {
        return new BoxEffect();
    }
}
