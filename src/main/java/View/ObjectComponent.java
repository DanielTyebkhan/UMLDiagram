package View;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

import java.util.List;
import java.util.ArrayList;
import java.util.function.Consumer;

import Document.ObjectClass;
import Document.Notable;
import Document.Storage;
import Document.Arrow;

import View.Listeners.AddClassListener;
import View.Listeners.AddNotableHandler;
import View.Listeners.RemoveHandler;
import View.ArrowDrawer;
import View.NotableDrawer;
import View.ThemeObject;


/**
 * A class to draw objects on the diagram
 * @author Daniel Tyebkhan
 * @author Anhad Gande
 */
public class ObjectComponent implements MouseListener, MouseMotionListener {
	private static final String DELETE = "Delete";

	private static final int WIDTH  = 100;
	private static final int HEIGHT = 30;

	private static final int FONT_SIZE = 12;
	private static final String FONT_NAME = "Calibri";

	private JPanel panel;
	private ObjectClass obj;

	private int clickX;
	private int clickY;
	private int incWidth = 0;
	private int incHeight = 0;

	private boolean selected;

	private ArrayList<NotableDrawer> nameLabel;
	private ArrayList<NotableDrawer> methodLabels;
	private ArrayList<NotableDrawer> variableLabels;
	private ArrayList<NotableDrawer> stereotypeLabels;


	/**
	 * Constructs an item to draw an object
	 * @param obj the object to draw
	 */
	public ObjectComponent(ObjectClass obj) {
		this.obj = obj;
		panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));

		panel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		panel.addMouseListener(this);
		panel.addMouseMotionListener(this);

		nameLabel = new ArrayList<>();
		nameLabel.add(new ClassNotableDrawer(obj, panel, WIDTH, HEIGHT));
		stereotypeLabels = new ArrayList<>();
		methodLabels = new ArrayList<>();
		variableLabels = new ArrayList<>();
	}

	/**
	 * Gets the associated object
	 * @return the associated object
	 */
	public ObjectClass getObject() {
		return obj;
	}

	/**
	 * Updates the names of the class, variables, stereotypes, and methods
	 */
	private void updateLabels() {
		for (Notable variable : obj.getInstanceVariables()) {
			if (!hasLabel(variableLabels, variable)) 
				variableLabels.add(new NotableDrawer(variable, obj::removeInstanceVariable, panel, WIDTH, HEIGHT));
		}
		for (Notable stereotype : obj.getStereotypes()) {
			if (!hasLabel(stereotypeLabels, stereotype)) 
				stereotypeLabels.add(new NotableDrawer(stereotype, obj::removeStereotype, panel, WIDTH, HEIGHT));
		}
		for (Notable method : obj.getMethods()) {
			if (!hasLabel(methodLabels, method)) 
				methodLabels.add(new NotableDrawer(method, obj::removeMethod, panel, WIDTH, HEIGHT));
		}
		removeNotPresent(variableLabels, obj.getInstanceVariables());
		removeNotPresent(stereotypeLabels, obj.getStereotypes());
		removeNotPresent(methodLabels, obj.getMethods());
	}

	/**
	 * Removes components which are no longer needed
	 */
	private void removeNotPresent(List<NotableDrawer> drawers, List<Notable> present) {
		ArrayList<NotableDrawer> toRemove = new ArrayList<>();
		for (NotableDrawer d : drawers) {
			if (!present.contains(d.getNotable()))
				toRemove.add(d);
		}
		for (NotableDrawer d : toRemove) {
			drawers.remove(d);
		}
	}

	/**
	 * Checks if there is a component for an object
	 * @param labels the list of labels to check
	 * @param nble the object to check for
	 * @return true if the object is present else false
	 */
	private boolean hasLabel(ArrayList<NotableDrawer> labels, Notable nble) {
		boolean present = false;
		for (NotableDrawer d : labels) {
			if (d.getNotable().equals(nble))
				present = true;
		}
		return present;
	}

	/**
	 * Increments the height of the object
	 */
	private void incrementHeight() {
		incHeight += HEIGHT;
	}

	/**
	 * Increments the width of the object
	 */
	private void incrementWidth() {
		incWidth += WIDTH;
	}

	/**
	 * Draws a set of items and associates their arrows with their positions on screen
	 * @param list the items to draw
	 * @param arrows the arrows to associate
	 */
	private void drawLabelList(List<NotableDrawer> list, List<ArrowDrawer> arrows) {
		Point clicked = obj.getPosition();
		for (NotableDrawer toDraw : list) {
			toDraw.draw();
			incrementHeight();
			for (ArrowDrawer arrow : arrows) {
				if (arrow.getArrow().getFrom().equals(toDraw.getNotable())) {
					arrow.setFromPosition(new Point((int)clicked.getX() + WIDTH, incHeight - (1/4) * HEIGHT + (int)clicked.getY()));
				}
				if (arrow.getArrow().getTo().equals(toDraw.getNotable())) {
					arrow.setToPosition(new Point((int)clicked.getX(), incHeight - (1/4) * HEIGHT + (int)clicked.getY()));
				}
			}
		}
	}

	/**
	 * Draws the object being represented
	 * @param reference the component being drawn on
	 * @param arrows arrows to associate with parts of the component
	 */
	public void drawShape(JPanel reference, List<ArrowDrawer> arrows) {
		panel.removeAll();
		Point clicked = obj.getPosition();
		updateLabels();
		drawLabelList(stereotypeLabels, arrows);
		drawLabelList(nameLabel, arrows);
		drawLabelList(variableLabels, arrows);
		drawLabelList(methodLabels, arrows);

		Dimension dimension = reference.getSize();
		Dimension size = panel.getPreferredSize();
		panel.setBounds((int)clicked.getX(),(int)clicked.getY(), size.width , size.height);
		reference.add(panel);
	}

	/**
	 * Handles Mouse event: clicked
	 * @param MouseEvent e
	 */
	public void mouseClicked(MouseEvent e) {
	}

	/**
	 * Handles Mouse event: Entered
	 * @param MouseEvent e
	 */
	public void mouseEntered(MouseEvent e) {

	}

	/**
	 * Handles Mouse event: Exited
	 * @param MouseEvent e
	 */
	public void mouseExited(MouseEvent e) {

	}

	/**
	 * Handles Mouse event: Pressed
	 * @param MouseEvent e
	 */
	public void mousePressed(MouseEvent e) {
		clickX = e.getXOnScreen();
		clickY = e.getYOnScreen();
		selected = true;
		panel.setBorder(BorderFactory.createLineBorder(Color.blue));

	}

	/**
	 * Handles Mouse event: Released
	 * @param MouseEvent e
	 */
	public void mouseReleased(MouseEvent e) {
		selected = false;
		panel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
	}

	/**
	 * Handles Mouse event: Dragged
	 * @param MouseEvent e
	 */
	public void mouseDragged(MouseEvent e) {
		int deltaX = e.getXOnScreen() - clickX;
		int deltaY = e.getYOnScreen() - clickY;
		Point prevPos = obj.getPosition();
		obj.setPosition(new Point((int)prevPos.getX() + deltaX, (int)prevPos.getY() + deltaY));
		clickX = e.getXOnScreen();
		clickY = e.getYOnScreen();
	}

	/**
	 * Handles Mouse event: Moved
	 * @param MouseEvent e
	 */
	public void mouseMoved(MouseEvent e) {

	}
	
}
