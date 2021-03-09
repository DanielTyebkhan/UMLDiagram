package View;

import java.awt.Color;

import javax.swing.*;
import java.util.List;
import java.util.ArrayList;

import Document.ObjectClass;
import Document.Storage;

import java.awt.*;

/**
 *  
 * @author Sai Lyon Ho
 */
public class ThemeObject extends JFrame 
{
    // public static ThemeObject theme = new ThemeObject();

    private final static String FRAME_NAME = "Theme Selector";
    private final static String CLASS_COLOR = "Class Color";
	private final static String BORDER_COLOR = "Border Color";
	private final static String DIAGRAM_COLOR = "Diagram Color";
	private final static String ARROW_COLOR = "Arrow Color";
	private final static String ARROW_THICKNESS = "Arrow Thickness";
	private final static String BORDER_THICKNESS = "Border Thickness";
    private final static String FONT = "Font";

    private ColorChooserButton classColorChooser;
    private ColorChooserButton borderColorChooser;
    private ColorChooserButton diagramColorChooser;
    private ColorChooserButton arrowColorChooser;

	private JComboBox font;

	private JButton save;

	private JPanel panel;

    private List<ObjectClass> objectsList;

    public ThemeObject() 
    {
        super(FRAME_NAME);
        panel = new JPanel();
        // objectsList = Storage.instance.getObjects();

        setClassColor();
        setBorderColor();
        setDiagramColor();
        setArrowColor();

        save = new JButton("Save");
        // save.addActionListener(SaveThemeActionListener(setBorderColor(), getPanel());
        panel.add(save);

        panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));

		this.add(panel);
		this.setSize(400, 500);
		this.setVisible(true);
    }

    public void setClassColor() 
    {   
        classColorChooser = new ColorChooserButton(Color.BLACK, CLASS_COLOR);
        panel.add(classColorChooser);
    }

    public Color getClassColor()
    {
        return classColorChooser.getSelectedColor();
    }
    public void setBorderColor()
    {
        borderColorChooser = new ColorChooserButton(Color.BLACK, BORDER_COLOR);
        panel.add(borderColorChooser);
    }
    public void setDiagramColor() 
    {
        diagramColorChooser = new ColorChooserButton(Color.BLACK, DIAGRAM_COLOR);
        panel.add(diagramColorChooser);
    }
    public void setArrowColor() 
    {
        arrowColorChooser = new ColorChooserButton(Color.BLACK, ARROW_COLOR);
        panel.add(arrowColorChooser);
    }

    
}
