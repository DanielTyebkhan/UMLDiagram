package View;

import java.awt.event.*; 
import java.awt.*; 
import javax.swing.*;
// import com.apple.eio.FileManager;

public class WindowClass extends JPanel{
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

        //Creating the MenuBar and adding components
        JMenuBar mb = new JMenuBar();
        JMenu m1 = new JMenu("File");
        JMenu m2 = new JMenu("Help");
        JMenu m3 = new JMenu("Export");
        mb.add(m1);
        mb.add(m2);
        mb.add(m3);
        JMenuItem m11 = new JMenuItem("Open");
        JMenuItem m22 = new JMenuItem("Save as");
        m1.add(m11);
        m1.add(m22);

        //Creating the panel at bottom and adding components
        JPanel panel = new JPanel(); // the panel is not visible in output
        JButton send = new JButton("Add Diagram");
        JButton reset = new JButton("Delete");
        panel.add(send);
        panel.add(reset);

        //Creating main panel displaying the diagrams of paintComponent
        WindowClass paintPanel = new WindowClass();

        //Adding Components to the frame.
        frame.getContentPane().add(BorderLayout.SOUTH, panel);
        frame.getContentPane().add(BorderLayout.NORTH, mb);
        frame.getContentPane().add(BorderLayout.CENTER, paintPanel);
        frame.setVisible(true);   
    }  
}