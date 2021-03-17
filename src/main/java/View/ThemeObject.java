package View;

import java.awt.Color;

/**
 *  Represents the global theme settings as an abstract class
 * @author Sai Lyon Ho
 */
public abstract class ThemeObject implements Cloneable{
    protected ThemeType type;
    protected Color classColor;
    protected Color borderColor;
    protected Color diagramColor;
    protected Color arrowColor;

    /**
     * Allows object to be cloned
     */
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    /**
     * Checks what type of theme the object contains 
     * @param type is specific ThemeType 
     * @return a boolean true or false 
     */
    public boolean isType(ThemeType type) {
        return this.type.equals(type);
    }

    public ThemeType getType() {
        return type;
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
