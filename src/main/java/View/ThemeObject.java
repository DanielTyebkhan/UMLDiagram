package View;

import java.awt.Color;

/**
 *  
 * @author Sai Lyon Ho
 */
public abstract class ThemeObject implements Cloneable{
    private ThemeType type;
    private Color classColor;
    private Color borderColor;
    private Color diagramColor;
    private Color arrowColor;

    public boolean isType(ThemeType type) {
        return this.type.equals(type);
    }
    public Color getClassColor(){
        return classColor;
    }
    public Color getBorderColor(){
        return borderColor;
    }
    public Color getDiagramColor(){
        return diagramColor;
    }
    public Color getArrowColor(){
        return arrowColor;
    }

    public void setClassColor(Color color) {
        classColor = color;
    }
    public void setBorderColor(Color color) {
        borderColor = color;
    }
    public void setDiagramColor(Color color) {
        diagramColor = color;
    }
    public void setArrowColor(Color color) {
        arrowColor = color;
    }
}
