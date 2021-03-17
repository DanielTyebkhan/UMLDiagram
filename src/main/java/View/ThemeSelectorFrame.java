package View;

import java.awt.Color;

import javax.swing.*;
import java.util.List;
import java.util.ArrayList;

import Document.ObjectClass;
import Document.Storage;

import java.awt.*;

/**
 * Creates the frame for changing the themes
 * @author Sai Lyon Ho
 * @author Daniel Tyebkhan
 */
 */
public class ThemeSelectorFrame extends JFrame 
{
    private final static String FRAME_NAME = "Theme Selector";
    private JPanel panel; 

    /**
     * Constructs the frame and its buttons using the 
     * global singleton instancc of ThemeManager 
     */
    public ThemeSelectorFrame()
    {

        super(FRAME_NAME);
        panel = new JPanel();

        ArrayList<ColorChooserButton> colorChoosers = new ArrayList<ColorChooserButton>(4);
        ColorChooserButton diagramColor = new ColorChooserButton(ThemeManager.instance.getDiagramColor(), "Diagram Color", ThemeManager.instance::setDiagramColor, ThemeManager.instance::getDiagramColor);
        ColorChooserButton classColor   = new ColorChooserButton(ThemeManager.instance.getClassColor(), "Class Color", ThemeManager.instance::setClassColor, ThemeManager.instance::getClassColor);
        ColorChooserButton borderColor  = new ColorChooserButton(ThemeManager.instance.getBorderColor(), "Border Color", ThemeManager.instance::setBorderColor, ThemeManager.instance::getBorderColor);
        ColorChooserButton arrowColor   = new ColorChooserButton(ThemeManager.instance.getArrowColor(), "Arrow Color", ThemeManager.instance::setArrowColor, ThemeManager.instance::getArrowColor);
        colorChoosers.add(diagramColor);
        colorChoosers.add(classColor);
        colorChoosers.add(borderColor);
        colorChoosers.add(arrowColor);
        JComboBox<ThemeObject> themesCombo = new JComboBox<ThemeObject>(ThemeManager.instance.getThemes());
        themesCombo.addItemListener(new ThemeItemChangeListener());

        panel.add(themesCombo);
        for (ColorChooserButton button : colorChoosers) {
            ThemeManager.instance.attachObserver(button);
            panel.add(button);
        }
        
        panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
        this.add(panel);
		this.setSize(400, 500);
		this.setVisible(true);
    }

    
}
