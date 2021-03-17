package View;

import java.awt.Color;

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

    @Override 
    public Object clone() throws CloneNotSupportedException {
        ThemeObject clone = (ThemeObject)super.clone();
        return clone;
        // DarkTheme clone = new DarkTheme();
        // clone.setArrowColor(arrowColor);
        // clone.setDiagramColor(diagramColor);
        // clone.setBorderColor(borderColor);
        // clone.setClassColor(classColor);
        // return clone;
    }
    
}
