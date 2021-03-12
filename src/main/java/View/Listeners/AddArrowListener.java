package View.Listeners;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import Document.Notable;
import View.Arrows.ArrowSelector;
import View.DiagramPanel;

/**
 * A listener to add a arrow to the diagram
 * @author Anhad Gande
 */
public class AddArrowListener extends Listener implements ActionListener {

	private Notable notable;

    /**
     * Constructs the listener
     * @param notable the object to add the arrow from
     */
	public AddArrowListener(Notable notable, DiagramPanel dPanel) {
        super(dPanel);
		this.notable = notable;
	}
    /**
     * 
     * @param e the trigger
     */
    public void actionPerformed(ActionEvent e) {
        new ArrowSelector(notable, getPanel());
    }
}

