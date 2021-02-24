package View;

import java.awt.event.*; 
import java.awt.*; 
import javax.swing.*;

import View.DiagramPanel;

/**
* WindowClass creates a frame containing the MenuPanel 
* in the top and the DiagramPanel in the center
*
* @author  
*/
public class WindowClass extends JPanel{
    private static final int SIZE = 500;

    public WindowClass() {
        JFrame frame = new JFrame("Build Your Diagram!");
        new MenuPanel(frame);

        frame.add(BorderLayout.CENTER, new DiagramPanel());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(SIZE, SIZE);
        frame.setVisible(true); 
    }

    public static void main(String[] args){
        new WindowClass();
    }  
}
