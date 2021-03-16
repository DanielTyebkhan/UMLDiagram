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
    
    private JButton close;

    private JPanel panel; 

    public ThemeSelectorFrame()
    {

        super(FRAME_NAME);
        panel = new JPanel();

        close = new JButton("Close");
        // save.addActionListener(SaveThemeActionListener(setBorderColor(), getDiagramPanel());
        panel.add(close);

        panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
        this.add(panel);
		this.setSize(400, 500);
		this.setVisible(true);
    }

    
}
