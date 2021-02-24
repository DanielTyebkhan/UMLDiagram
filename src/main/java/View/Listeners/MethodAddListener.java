package View.Listeners;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

import View.ObjectComponent;

public class MethodAddListener implements MouseListener {
        private ObjectComponent instance;
        private JPanel panel;
        JPopupMenu varMenu;
        JMenuItem varItem;
        
        public MethodAddListener(ObjectComponent obj, JPanel panel) {
            instance = obj;
            this.panel = panel;

        }

        public void mouseClicked(MouseEvent e)
        {
        	// if(e.getButton() == MouseEvent.BUTTON3) {
	        //     String newMethod = JOptionPane.showInputDialog(panel, "Enter new method name");
	        //     instance.addMethod(newMethod);
        	// }
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