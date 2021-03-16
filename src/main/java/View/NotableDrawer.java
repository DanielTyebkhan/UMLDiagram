package View;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import Document.Notable;
import General.Command;

import View.Listeners.CommandListener;
import View.Listeners.AddArrowListener;

/**
 * Draws the name of a variable, class, method, or stereotype
 * @author Daniel Tyebkhan
 */
public class NotableDrawer implements MouseListener, MouseMotionListener {
	protected static final int FONT_SIZE = 12;
	protected static final String FONT_NAME = "Calibri";
	protected static final String DELETE = "Delete";
	protected static final String ADD_ARROW = "Add Arrow From";

	protected Notable notable;

	protected JLabel label;
	protected JPanel parent;

	protected JPopupMenu menu;

	/**
	 * Constructs an object to do the drawing
	 * @param notable the object to draw
	 * @param remover the function to remove the object from the diagram
	 * @param parent the object to draw in
	 * @param width the width of the object
	 * @param height the height of the object
	 */
 	
	public NotableDrawer(Notable notable, Command remover, JPanel parent, int width, int height, DiagramPanel diagramPanel) {
		this.notable = notable;
		this.parent = parent;
		
		menu = new JPopupMenu();
		JMenuItem deleteItem = new JMenuItem(DELETE);
		JMenuItem addArrow = new JMenuItem(ADD_ARROW);
		deleteItem.addActionListener(new CommandListener(diagramPanel, remover));
		addArrow.addActionListener(new AddArrowListener(getNotable(), diagramPanel));
		menu.add(deleteItem);
		menu.add(addArrow);
		label = new JLabel(notable.getName());
		label.setPreferredSize(new Dimension(width, height));
		label.setMaximumSize(new Dimension(width, height));
		label.setBorder(BorderFactory.createLineBorder(ThemeManager.instance.getBorderColor()));
		label.setFont(new Font(FONT_NAME, Font.PLAIN, FONT_SIZE));
		label.addMouseListener(this);
		label.addMouseMotionListener(this);
	}

	/**
	 * Draws the object
	 */
	public void draw() {
		label.setText(notable.getName());
		parent.add(label);
	}

	/**
	 * Gets the associated object
	 * @return the associated object
	 */
	public Notable getNotable() {
		return notable;
	}

	/**
	 * Handles the object being clicked
	 * @param e the click event
	 */
	public void mouseClicked(MouseEvent e) {
		if (e.getButton() == MouseEvent.BUTTON3) {
			menu.show(parent, e.getX(), e.getY());
		}
		else
			parent.dispatchEvent(e);
	}

	/**
	 * Handles the object being pressed
	 * @param e the trigger
	 */
	public void mousePressed(MouseEvent e) {
		parent.dispatchEvent(e);
	}

	/**
	 * Handles the object being released
	 * @param e the trigger
	 */
	public void mouseReleased(MouseEvent e) {
		parent.dispatchEvent(e);
	}

	/**
	 * Handles the object being entered
	 * @param e the trigger
	 */
	public void mouseEntered(MouseEvent e) {
		parent.dispatchEvent(e);
	}

	/**
	 * Handles the object being exited
	 * @param e the trigger
	 */
	public void mouseExited(MouseEvent e) {
		parent.dispatchEvent(e);
	}

	/**
	 * Handles the mouse being moved
	 * @param e the trigger
	 */
	public void mouseMoved(MouseEvent e) {
		parent.dispatchEvent(e);
	}

	/**
	 * Handles the object being dragged
	 * @param e the trigger
	 */
	public void mouseDragged(MouseEvent e) {
		parent.dispatchEvent(e);
	}
}
		

