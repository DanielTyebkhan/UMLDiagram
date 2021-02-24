package View;

import java.awt.event.*; 
import java.awt.*; 
import javax.swing.*;

import View.DiagramPanel;

/**
* WindowClass creates the MenuPanel and the DiagramPanel
*
* @author  
*/
public class WindowClass extends JPanel{
    private static final int size = 500;

    public WindowClass() {
        JFrame frame = new JFrame("Build Your Diagram!");
        new MenuPanel(frame);
        frame.add(BorderLayout.CENTER, new DiagramPanel());
        DiagramPanel diagramPanel = new DiagramPanel();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(size, size);
        frame.setVisible(true); 
    }

    public static void main(String[] args){
        new WindowClass();
    }  
}
