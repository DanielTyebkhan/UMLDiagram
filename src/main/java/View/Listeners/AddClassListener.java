package View.Listeners;

import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.awt.Container;
import java.awt.Point;
import javax.swing.JOptionPane;

import Document.ObjectClass;
import Document.Storage;

/**
 * A listener to add a class to the diagram
 * @author Daniel Tyebkhan
 */
public class AddClassListener implements MouseListener {
    private static final String CLASS_NAME_PROMPT = "Enter Class Name";

    public void mouseClicked(MouseEvent e) 
    {
       
    }
    public void mouseEntered(MouseEvent e)
    {

    }

    public void mouseExited(MouseEvent e) {

    }

    /**
     * Prompts the user for a classname then adds the class to the diagram
     * @param e the trigger
     */
    public void mousePressed(MouseEvent e) {
        String name = JOptionPane.showInputDialog(e.getComponent(), CLASS_NAME_PROMPT);
        if (name != null && !name.equals(""))
            Storage.instance.addObject(new ObjectClass(name, new Point(e.getPoint())));
    }

    public void mouseReleased(MouseEvent e) {
    }

}

