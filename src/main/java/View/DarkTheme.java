package View;

import java.awt.Color;


/**
 * Sets theme properties from ThemeObject 
 * by default to its dark version
 * @author Daniel Tyebkhan
 */
public class DarkTheme extends ThemeObject {
    public DarkTheme() {
        type = ThemeType.DARK;
        classColor = Color.decode("#BDBDBD");
        diagramColor = Color.decode("#212121");
        arrowColor = Color.decode("#FF9800");
        borderColor = Color.decode("#BDBDBD");
    }

    @Override
    public String toString() {
        return "Dark";
    }
}
