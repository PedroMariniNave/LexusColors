package com.zpedroo.lexuscolors;

import com.zpedroo.lexuscolors.objects.Color;
import org.apache.commons.lang.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class Colors {

    private static List<Color> colors;

    static {
        colors = new ArrayList<>(32);
    }

    public static List<Color> getColors() {
        return colors;
    }

    public static Color getColor(String str) {
        for (Color color : getColors()) {
            if (StringUtils.equalsIgnoreCase(color.getName(), str.replace("&", ""))) {
                return color;
            }
        }

        return null;
    }
}