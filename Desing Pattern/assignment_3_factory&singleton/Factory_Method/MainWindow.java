package com.Factory_Method;

public abstract class MainWindow {
    public Widget showWidget() {
        Widget widget = createWidget();
        widget.setWidget();
        return widget;
    }

    protected abstract Widget createWidget();
}
