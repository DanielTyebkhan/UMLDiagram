package View;

import Document.Storage;
import Document.ObjectClass;
import General.Observer;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

/**
 * @author Daniel Tyebkhan
 */
public class TestView extends JPanel implements MouseListener, Observer {
    Storage storage;
    JPopupMenu rcmenu;
    JMenuItem newClass;
    static JFrame frame;

    private static final int size = 500;

    public TestView() {
       storage = new Storage();
       storage.addObserver(this);
       setSize(new Dimension(size, size));

       rcmenu = new JPopupMenu();
       newClass = new JMenuItem("New Class");
       newClass.addMouseListener(new NewClassListener());
       rcmenu.add(newClass);
       frame = new JFrame("Design Diagrams");
       frame.setSize(size,size);
       frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       addMouseListener(this);
    }

    public void update() {
        repaint();
        System.out.println("testing update");
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
    }


    public void mouseClicked(MouseEvent e)
    {
        if (e.getButton() == MouseEvent.BUTTON3) { 
            rcmenu.show(frame, e.getX(), e.getY());
            repaint();
        }
    }
    public void mouseEntered(MouseEvent e)
    {

    }
    public void mouseExited(MouseEvent e)
    {

    }
    public void mousePressed(MouseEvent e)
    {

    }

    public void mouseReleased(MouseEvent e)
    {

    }

    public static void main(String[] args) {
        TestView view = new TestView();
        frame.add(view);
        frame.setVisible(true);
    }

    class NewClassListener implements MouseListener {
        public void mouseClicked(MouseEvent e)
        {
        }
        public void mouseEntered(MouseEvent e)
        {

        }
        public void mouseExited(MouseEvent e)
        {

        }
        public void mousePressed(MouseEvent e)
        {
            rcmenu.setVisible(false);
            String name = JOptionPane.showInputDialog(frame, "Enter ClassName", "Class0");
            ObjectClass obj = new ObjectClass(name, new int[] {0, 0});
            storage.addObject(obj);
            
        }

        public void mouseReleased(MouseEvent e)
        {

        }
    }
}
