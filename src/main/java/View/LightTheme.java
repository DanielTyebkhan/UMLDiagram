package View;

import java.awt.Color;

public class LightTheme extends ThemeObject {
    public LightTheme() {
        type = ThemeType.LIGHT;
        classColor = Color.WHITE;
        diagramColor = Color.WHITE;
        arrowColor = Color.BLACK;
        borderColor = Color.BLACK;
    }

    @Override
    public String toString() {
        return "Light";
    }

}
