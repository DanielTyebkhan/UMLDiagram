package View.Listeners;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

import View.ObjectComponent;

/**
 * A listener to add methods to an object
 * @author Daniel Tyebkhan
 * @author Anhad Gande
 */
public class MethodAddListener implements MouseListener {
    private static final String ENTER_NAME = "Enter method name";
    private ObjectComponent object;

    public MethodAddListener(ObjectComponent object, JPanel parent) {
        this.object = object;
    }

    public void mouseClicked(MouseEvent e) {
        String newMethod = JOptionPane.showInputDialog(e.getComponent(), ENTER_NAME);
        object.addMethod(newMethod);
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
