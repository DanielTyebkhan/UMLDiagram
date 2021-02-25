package View.Listeners;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Container;
import java.awt.Point;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import Document.ObjectClass;
import Document.Storage;
import Document.Notable;

import View.DiagramPanel;
import View.ArrowSelector;

/**
 * A listener to add a arrow to the diagram
 * @author Anhad Gande
 */
public class AddArrowListener implements ActionListener {

	private Notable notable;

    /**
     * Constructs the listener
     * @param notable the object to add the arrow from
     */
	public AddArrowListener(Notable notable) {
		this.notable = notable;
	}
    /**
     * 
     * @param e the trigger
     */
    public void actionPerformed(ActionEvent e) {
        new ArrowSelector(notable);
    }
}

