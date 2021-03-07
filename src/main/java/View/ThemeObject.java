package View;

import java.awt.Color;

import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JPanel;

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
    // private ColorChooserButton borderColorChooser;
    // private ColorChooserButton diagramColorChooser;
    // private ColorChooserButton arrowColorChooser;

	private JComboBox font;

	private JButton save;
	private JPanel panel;

    public ThemeObject()
    {
        super(FRAME_NAME);
        panel = new JPanel();

        JLabel classColorText = new JLabel(CLASS_COLOR);
        classColorChooser = new ColorChooserButton(Color.BLACK);

        panel.add(classColorText); 
        panel.add(classColorChooser);

        panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));

		this.add(panel);
		this.setSize(400, 500);
		this.setVisible(true);
    }
    
}
