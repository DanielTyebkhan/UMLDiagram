package View.Listeners;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

import View.ObjectComponent;

public class VarAddListener implements MouseListener {
        private ObjectComponent instance;
        JPopupMenu varMenu;
        JMenuItem varItem;
        
        public VarAddListener(ObjectComponent obj) {
            instance = obj;
        }

        public void mouseClicked(MouseEvent e)
        {
            // String newVar = JOptionPane.showInputDialog(panel, "Enter new variable name");
            // instance.addVariable(newVar);
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