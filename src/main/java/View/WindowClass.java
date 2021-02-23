package View;

import java.awt.event.*; 
import java.awt.*; 
import javax.swing.*;
// import com.apple.eio.FileManager;

public class WindowClass extends JPanel{
    private static final int size = 500;

    public WindowClass() {
        JFrame frame = new JFrame("Build Your Diagram!");
        new MenuPanel(frame);
        DiagramPanel diagramPanel = new DiagramPanel();
        
        frame.getContentPane().add(BorderLayout.CENTER, diagramPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(size, size);
        frame.setVisible(true); 
    }

    public static void main(String[] args){
        new WindowClass();
    }  
}