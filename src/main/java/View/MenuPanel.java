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
    
    public MenuPanel(JFrame frame)
    {   
        menuBar = new JMenuBar();
        open();
        saveAs();
        export();
        frame.getContentPane().add(BorderLayout.NORTH, menuBar);
    }
    
    public void open()
    {
        JMenu m = new JMenu("Open");
        menuBar.add(m);
    } 
    public void export()
    {
        JMenu m = new JMenu("Export");
        menuBar.add(m);
    }
    public void saveAs()
    {
        JMenu m = new JMenu("Save As");
        menuBar.add(m);
    }
}
