package com.zpedroo.lexuscolors.data;

import com.zpedroo.lexuscolors.objects.Color;

public class PlayerData {

    private Color color;

    public PlayerData(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
}