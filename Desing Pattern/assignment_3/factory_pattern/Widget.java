package com.factory_pattern;

import javax.swing.text.Style;

public abstract class Button {

    public String btnlbl;

    public Button(String buttonLable) {
        this.btnlbl = buttonLable;
    }


    public Button RenderButton(){
        
    }

    // factory methods
    public abstract StyleSheet setStyle();

    public abstract GraphicEffect setEffect();

}
