package View;

import View.Listeners.OpenFileListener;
import View.Listeners.AddDiagramListener;
import View.Listeners.ExportFileListener;
import View.Listeners.SaveFileListener;
import View.Listeners.ExportCodeListener;
import View.Theme.ThemeSelectorMouseListener;

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
    private WindowClass window;
    
    /**
     * Constructs the MenuPanel positioned at the top of the frame
     * @param frame a JFrame passed from WindowClass to position the MenuPanel
     */
    public MenuPanel(JFrame frame, WindowClass window)
    {   
        this.window = window;
        menuBar = new JMenuBar();
        open();
        saveAs();
        export();
        changeTheme();
        addPanel();
	exportCode();
        frame.getContentPane().add(BorderLayout.NORTH, menuBar);
    }

    public void addPanel() {
        JMenu m = new JMenu("New Diagram"); 
        m.addMouseListener(new AddDiagramListener(window));
        menuBar.add(m);
    }

    /**
     * Constructs open button that allows user to choose which file 
     * to keep working on by using JFileChooser
     */
    public void open()
    {
        JMenu m = new JMenu("Open");
        menuBar.add(m);
        m.addMouseListener(new OpenFileListener(window));
    } 

    /**
     * Constructs export button that allows user to export and convert
     * file to JPEG 
     */
    public void export()
    {
        JMenu m = new JMenu("Export");
        menuBar.add(m);
        m.addMouseListener(new ExportFileListener(window));
    }

    /**
     * Constructs save button that allows user to save the current project
     * by using the JFileChooser
     */
    public void saveAs()
    {
        JMenu m = new JMenu("Save As");
        menuBar.add(m);
        m.addMouseListener(new SaveFileListener(window));
    }

    /**
     * Constructs and adds the button to change theme
     */
    public void changeTheme()
    {
        JMenu m = new JMenu("Change Theme");
        menuBar.add(m);
        m.addMouseListener(new ThemeSelectorMouseListener());
    }
	
    public void exportCode()
    {
        JMenu m = new JMenu("Export Code");
        menuBar.add(m);
        m.addMouseListener(new ExportCodeListener(window));
    }
}
