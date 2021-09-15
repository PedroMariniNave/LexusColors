package com.zpedroo.lexuscolors.objects;

public class Color {

    private String color;

    public Color(String color) {
        this.color = color.startsWith("&") ? color : "&" + color;
    }

    public String getColor() {
        return color;
    }

    public String getName() {
        return color.replace("&", "");
    }
}