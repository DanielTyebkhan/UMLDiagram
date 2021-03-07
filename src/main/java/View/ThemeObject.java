package View;

import java.awt.Color;

import javax.swing.*;
import java.awt.*;

/**
 *  
 * @author Sai Lyon Ho
 */
public class ThemeObject extends JFrame {
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

    // private JPanel classColorPanel;
	// private JPanel borderColorPanel;
	// private JPanel diagramColorPanel;
	// private JPanel arrowColorPanel;
	private JPanel panel;

    public ThemeObject()
    {
        super(FRAME_NAME);
        panel = new JPanel();

        // JLabel classColorText = new JLabel(CLASS_COLOR);
        classColorChooser = new ColorChooserButton(Color.BLACK, CLASS_COLOR);
        // classColorPanel.add(classColorText); 
        // classColorPanel.add(classColorChooser);
        // panel.add(classColorText); 
        panel.add(classColorChooser);
        // classColorPanel.setLayout(new BoxLayout(classColorPanel, BoxLayout.X_AXIS));
        // panel.add(classColorPanel);

        // JLabel borderColorText = new JLabel(BORDER_COLOR);
        borderColorChooser = new ColorChooserButton(Color.BLACK, BORDER_COLOR);
        // panel.add(borderColorText); 
        panel.add(borderColorChooser);

        // JLabel diagramColorText = new JLabel(DIAGRAM_COLOR);
        diagramColorChooser = new ColorChooserButton(Color.BLACK, DIAGRAM_COLOR);
        // panel.add(diagramColorText); 
        panel.add(diagramColorChooser);

        // JLabel arrowColorText = new JLabel(ARROW_COLOR);
        arrowColorChooser = new ColorChooserButton(Color.BLACK, ARROW_COLOR);
        // panel.add(arrowColorText); 
        panel.add(arrowColorChooser);


        panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
        // panel.setLayout(new GridLayout(0,2));

		this.add(panel);
		this.setSize(400, 500);
		this.setVisible(true);
    }
    
}
