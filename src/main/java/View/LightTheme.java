package View;

import java.awt.Color;

/**
 * Sets theme properties from ThemeObject 
 * by default to its light version
 * @author Daniel Tyebkhan
 */
public class LightTheme extends ThemeObject {

    /**
     * Constructs a light theme
     */
    public LightTheme() {
        type = ThemeType.LIGHT;
        classColor = Color.WHITE;
        diagramColor = Color.WHITE;
        arrowColor = Color.BLACK;
        borderColor = Color.BLACK;
    }

    /**
     * Converts the theme into a string
     * @return the string form of the theme
     */
    @Override
    public String toString() {
        return "Light";
    }

}
