package View;

import java.awt.event.*; 
import java.awt.*; 
import javax.swing.*;

public class MenuPanel extends JComponent {
    private JMenuBar menuBar;
    private JPanel bottomPanelBar;
    
    public MenuPanel(JFrame frame)
    {
        menuBar = new JMenuBar();
        bottomPanelBar = new JPanel();
        
        this.frame = frame;
        frame.getContentPane().add(BorderLayout.SOUTH, bottomPanelBar);
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
    public void addDiagramButton()
    {
        JButton button = new JButton("Add");
        bottomPanelBar.add(button);
    }
    public void deleteDiagramButton()
    {
        JButton button = new JButton("Delete");
        bottomPanelBar.add(button);
    }
}
