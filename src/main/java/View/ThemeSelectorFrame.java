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
public class ThemeSelectorFrame extends JFrame 
{
    private final static String FRAME_NAME = "Theme Selector";

    // private ColorChooserButton classColorChooser;
    // private ColorChooserButton borderColorChooser;
    // private ColorChooserButton diagramColorChooser;
    // private ColorChooserButton arrowColorChooser;
    
    private JButton save;

    private JPanel panel; 

    public ThemeSelectorFrame()
    {

        super(FRAME_NAME);
        panel = new JPanel();

        panel.add(ThemeObject.theme.setClassColor());
        panel.add(ThemeObject.theme.setDiagramColor());
        panel.add(ThemeObject.theme.setArrowColor());
        panel.add(ThemeObject.theme.setBorderColor());
        
        save = new JButton("Save");
        // save.addActionListener(SaveThemeActionListener(setBorderColor(), getPanel());
        panel.add(save);

        panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
        this.add(panel);
		this.setSize(400, 500);
		this.setVisible(true);
    }

    
}
