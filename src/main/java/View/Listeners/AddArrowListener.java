package View.Listeners;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Container;
import java.awt.Point;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import Document.ObjectClass;
import Document.Storage;

import View.DiagramPanel;
import View.ArrowSelector;

/**
 * A listener to add a arrow to the diagram
 * @author Anhad Gande
 */
public class AddArrowListener implements ActionListener {
    
    private DiagramPanel parent;

    public AddClassListener(DiagramPanel parent) {
        this.parent = parent;
    }

    /**
     * 
     * @param e the trigger
     */
    public void actionPerformed(ActionEvent e) {
        new ArrowSelector();
    }
}

