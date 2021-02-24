package View.Listeners;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

import View.ObjectComponent;

public class MethodAddListener implements MouseListener {
        private ObjectComponent instance;
        JPopupMenu varMenu;
        JMenuItem varItem;
        
        public MethodAddListener(ObjectComponent obj) {
            instance = obj;
        }

        public void mouseClicked(MouseEvent e)
        {
            // String newMethod = JOptionPane.showInputDialog(panel, "Enter new method name");
            // instance.addMethod(newMethod);
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