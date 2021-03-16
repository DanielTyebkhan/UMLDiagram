package View;

import java.awt.Color;

import javax.swing.*;
import java.util.List;
import java.util.ArrayList;

import Document.ObjectClass;
import Document.Storage;
import View.DiagramPanel;

import java.awt.*;

/**
 *  
 * @author Sai Lyon Ho
 */
public abstract class ThemeObject{
    private Color classColor;
    private Color borderColor;
    private Color diagramColor;
    private Color arrowColor;

    public ThemeObject() {
        
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
}

// public class ThemeObject
// {
//     public static ThemeObject theme = new ThemeObject();

//     private final static String CLASS_COLOR = "Class Color";
// 	private final static String BORDER_COLOR = "Border Color";
// 	private final static String DIAGRAM_COLOR = "Diagram Color";
// 	private final static String ARROW_COLOR = "Arrow Color";
//     private final static String FONT_COLOR = "Font Color";
// 	private final static String ARROW_THICKNESS = "Arrow Thickness";
// 	private final static String BORDER_THICKNESS = "Border Thickness";
//     private final static String FONT_STYLE = "Font Style";

//     private ColorChooserButton classColorChooser;
//     private ColorChooserButton borderColorChooser;
//     private ColorChooserButton diagramColorChooser;
//     private ColorChooserButton arrowColorChooser;

//     public ThemeObject(){
//         setClassColor();
//         setBorderColor();
//         setDiagramColor();
//         setArrowColor();
//     }

//     public ColorChooserButton setClassColor() 
//     {   
//         classColorChooser = new ColorChooserButton(Color.WHITE, CLASS_COLOR);
//         return classColorChooser;
//     }

//     public ColorChooserButton setBorderColor()
//     {
//         borderColorChooser = new ColorChooserButton(Color.BLACK, BORDER_COLOR);
//         return borderColorChooser;
//     }
//     public ColorChooserButton setDiagramColor() 
//     {
//         diagramColorChooser = new ColorChooserButton(Color.WHITE, DIAGRAM_COLOR);
//         return diagramColorChooser;
//     }
//     public ColorChooserButton setArrowColor() 
//     {
//         arrowColorChooser = new ColorChooserButton(Color.BLACK, ARROW_COLOR);
//         return arrowColorChooser;
//     }

//     /** ------------------------------------------------------------------------------------ */
//     public Color getClassColor()
//     {
//         return classColorChooser.getSelectedColor();
//     }

//     public Color getBorderColor()
//     {
//         return borderColorChooser.getSelectedColor();
//     }

//     public Color getDiagramColor()
//     {
//         return diagramColorChooser.getSelectedColor();
//     }

//     public Color getArrowColor()
//     {
//         return arrowColorChooser.getSelectedColor();
//     }

// }
