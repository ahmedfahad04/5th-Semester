package com.Factory_Method;

public class DialogWindow extends MainWindow{
    @Override
    public Widget createWidget() {
        return new DialogButton();
    }
}
