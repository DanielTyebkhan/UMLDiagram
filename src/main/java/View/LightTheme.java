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
    public Object clone() {
        DarkTheme clone = new DarkTheme();
        clone.setArrowColor(arrowColor);
        clone.setDiagramColor(diagramColor);
        clone.setBorderColor(borderColor);
        clone.setClassColor(classColor);
        return clone;
    }
    
}
