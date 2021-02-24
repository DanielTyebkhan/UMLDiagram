package View;

import Document.Storage;
import Document.ObjectClass;

import java.awt.event.*; 
import java.awt.*; 
import javax.swing.*;

/**
* MenuPanel creates the a panel containing 
* the open, saveAs and export buttons and methods
*
* @author  
*/
public class MenuPanel extends JComponent {
    private JMenuBar menuBar;
    
    /**
     * Constructs the MenuPanel positioned at the top of the frame
     * @param frame a JFrame passed from WindowClass to position the MenuPanel
     */
    public MenuPanel(JFrame frame)
    {   
        menuBar = new JMenuBar();
        open();
        saveAs();
        export();
        frame.getContentPane().add(BorderLayout.NORTH, menuBar);
    }
    /**
     * Constructs open button that allows user to choose which file 
     * to keep working on by using JFileChooser
     */
    public void open()
    {
        JMenu m = new JMenu("Open");
        menuBar.add(m);
    } 
    /**
     * Constructs export button that allows user to export and convert
     * file into... 
     */
    public void export()
    {
        JMenu m = new JMenu("Export");
        JMenuItem item1 = new JMenuItem("JPEG");
        JMenuItem item2 = new JMenuItem("PDF");
        m.add(item1);
        m.add(item2);
        menuBar.add(m);
    }
    /**
     * Constructs save button that allows user to save the current project
     * by using the JFileChooser
     */
    public void saveAs()
    {
        JMenu m = new JMenu("Save As");
        menuBar.add(m);
    }
}
