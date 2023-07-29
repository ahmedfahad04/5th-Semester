package com.Factory_Method;

public class TempWindow extends MainWindow{
    @Override
    public Widget createWidget() {
        return new TempButton();
    }
}
