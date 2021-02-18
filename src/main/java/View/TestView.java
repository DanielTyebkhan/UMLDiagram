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
        refresh();
    }

    private void refresh() {
        this.removeAll();
        for (ObjectClass obj : storage.getObjects()) {
            add(objShow(obj));
        }
        revalidate();
        frame.repaint();
    }

    public JTextArea objShow(ObjectClass obj) {
        StringBuilder text = new StringBuilder();
        text.append(obj.getName() + "\n");
        for (String variable : obj.getInstanceVariables()) 
            text.append(variable + "\n");
        JTextArea current = new JTextArea(text.toString());
        current.setEditable(false);
        current.addMouseListener(new VarAddListener(obj));
        return current;
    }

    class VarAddListener implements MouseListener {
        private ObjectClass instance;
        JPopupMenu varMenu;
        JMenuItem varItem;
        
        public VarAddListener(ObjectClass obj) {
            instance = obj;
        }

        public void mouseClicked(MouseEvent e)
        {
            String newVar = JOptionPane.showInputDialog("Enter new variable name");
            instance.addInstanceVariable(newVar);
            refresh();
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
    }

    public void mouseClicked(MouseEvent e)
    {
        if (e.getButton() == MouseEvent.BUTTON3) { 
            rcmenu.show(frame, e.getX(), e.getY());
            refresh();
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
