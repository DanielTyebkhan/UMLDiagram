package View;

import java.awt.event.*; 
import java.awt.*; 
import javax.swing.*;

import Document.Storage;
import Document.ObjectClass;

import View.Listeners.OpenFileListener;
import View.Listeners.ExportFileListener;
import View.Listeners.SaveFileListener;

/**
* MenuPanel creates the a panel containing 
* the open, saveAs and export buttons and methods
*
* @author  Sai Lyon Ho
*/
public class MenuPanel extends JComponent {
    private JMenuBar menuBar;
    
    /**
     * Constructs the MenuPanel positioned at the top of the frame
     * @param frame a JFrame passed from WindowClass to position the MenuPanel
     */
    public MenuPanel(JFrame frame, DiagramPanel diagramPanel)
    {   
        menuBar = new JMenuBar();
        open();
        saveAs();
        export(diagramPanel);
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
        m.addMouseListener(new OpenFileListener());
    } 

    /**
     * Constructs export button that allows user to export and convert
     * file into... 
     */
    public void export(DiagramPanel diagramPanel)
    {
        JMenu m = new JMenu("Export");
        menuBar.add(m);
        m.addMouseListener(new ExportFileListener(diagramPanel));
    }

    /**
     * Constructs save button that allows user to save the current project
     * by using the JFileChooser
     */
    public void saveAs()
    {
        JMenu m = new JMenu("Save As");
        menuBar.add(m);
        m.addMouseListener(new SaveFileListener());
    }
}
