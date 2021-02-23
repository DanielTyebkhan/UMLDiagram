package View.Listeners;

import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.awt.Container;
import java.awt.Point;
import javax.swing.JOptionPane;

import Document.ObjectClass;
import Document.Storage;

public class AddClassListener implements MouseListener {
    private static final String CLASS_NAME_PROMPT = "Enter Class Name";

    private Container container;

    public AddClassListener(Container container) {
        this.container = container;
    }

    public void mouseClicked(MouseEvent e) {
        System.out.println("Clicked");
        String name = JOptionPane.showInputDialog(container, CLASS_NAME_PROMPT);
        if (name != null || !name.equals(""))
            Storage.instance.addObject(new ObjectClass(name, new Point(e.getPoint())));
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
