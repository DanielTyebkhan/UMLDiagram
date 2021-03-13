package View;

import View.Listeners.OpenFileListener;
import View.Listeners.ExportFileListener;
import View.Listeners.SaveFileListener;
import View.Theme.ThemeSelectorMouseListener;
import View.Listeners.UndoListener;

import java.awt.*; 
import javax.swing.*;

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
    public MenuPanel(JFrame frame, WindowClass window)
    {   

        menuBar = new JMenuBar();
        open(window);
        saveAs(window);
        export(window);
        changeTheme();
        //undo(diagramPanel);
        frame.getContentPane().add(BorderLayout.NORTH, menuBar);
    }

    /**
     * Constructs open button that allows user to choose which file 
     * to keep working on by using JFileChooser
     */
    public void open(WindowClass window)
    {
        JMenu m = new JMenu("Open");
        menuBar.add(m);
        m.addMouseListener(new OpenFileListener(window.getCurrentDiagram()));
    } 

    public void undo(WindowClass window) {
        JMenu m = new JMenu("Undo");
        menuBar.add(m);
        m.addActionListener(new UndoListener(window.getCurrentDiagram()));
    }

    /**
     * Constructs export button that allows user to export and convert
     * file to JPEG 
     */
    public void export(WindowClass window)
    {
        JMenu m = new JMenu("Export");
        menuBar.add(m);
        m.addMouseListener(new ExportFileListener(window.getCurrentDiagram()));
    }

    /**
     * Constructs save button that allows user to save the current project
     * by using the JFileChooser
     */
    public void saveAs(WindowClass window)
    {
        JMenu m = new JMenu("Save As");
        menuBar.add(m);
        m.addMouseListener(new SaveFileListener(window.getCurrentDiagram()));
    }

    public void changeTheme()
    {
        JMenu m = new JMenu("Change Theme");
        menuBar.add(m);
        m.addMouseListener(new ThemeSelectorMouseListener());
    }
}
