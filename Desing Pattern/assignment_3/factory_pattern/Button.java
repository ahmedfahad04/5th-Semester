package com.factory_pattern;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;

public class Button {

    List<StyleSheet> styles = new ArrayList<>();

    public Button(){};

    public void addStyle(StyleSheet style){
        styles.add(style);
    };

    public void showDetails() {
        System.out.println("Available Styles: "+ styles.size());
    }


}
