package View;

import java.awt.Color;

public class DarkTheme extends ThemeObject {
    public DarkTheme() {
        type = ThemeType.DARK;
        classColor = Color.BLACK;
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
