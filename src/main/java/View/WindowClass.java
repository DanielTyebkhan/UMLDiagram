package View;

import java.awt.event.*; 
import java.awt.*; 
import javax.swing.*;
// import com.apple.eio.FileManager;

public class WindowClass extends JPanel{

    //Delete paintComponent when DiagramPanel implemented
    private static final int RECT_X = 20;
    private static final int RECT_Y = RECT_X;
    private static final int RECT_WIDTH = 100;
    private static final int RECT_HEIGHT = RECT_WIDTH;
    
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        // draw the rectangle here
        g.drawRect(RECT_X, RECT_Y, RECT_WIDTH, RECT_HEIGHT);
    }

    public static void main(String[] args){
        //Creating the Frame
        JFrame frame = new JFrame("Build Your Diagram!");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);

        //Creating main panel displaying the diagrams of paintComponent
        WindowClass paintPanel = new WindowClass();

      
        MenuPanel menu = new MenuPanel(frame);

        frame.getContentPane().add(BorderLayout.CENTER, paintPanel);
        frame.setVisible(true);   
    }  
}