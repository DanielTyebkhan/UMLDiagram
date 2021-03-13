package View;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import java.util.List;
import java.util.ArrayList;

import Document.ObjectClass;
import Document.Storage;
import View.Arrows.ArrowDrawer;
import View.Commands.DragCommand;
import View.Commands.NotableCommand;
import Document.Notable;


/**
 * A class to draw objects on the diagram
 * @author Daniel Tyebkhan
 * @author Anhad Gande
 */
public class ObjectComponent extends DiagramMember implements MouseListener, MouseMotionListener {
	private static final int WIDTH  = 100;
	private static final int HEIGHT = 30;

	private JPanel panel;
	private ObjectClass obj;

	private int clickX;
	private int clickY;
	private int currHeight;
	private boolean dragging;
	private Point oldPosition;

	private ArrayList<NotableDrawer> nameLabel;
	private ArrayList<NotableDrawer> methodLabels;
	private ArrayList<NotableDrawer> variableLabels;
	private ArrayList<NotableDrawer> stereotypeLabels;

	/**
	 * Constructs an item to draw an object
	 * @param obj the object to draw
	 */
	public ObjectComponent(DiagramPanel parent, ObjectClass obj) {
		super(parent);
		this.obj = obj;
		currHeight = 0;
		oldPosition = obj.getPosition();
		panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));

		panel.setBackground(ThemeObject.theme.getClassColor());
		panel.setBorder(BorderFactory.createLineBorder(ThemeObject.theme.getBorderColor()));
		panel.addMouseListener(this);
		panel.addMouseMotionListener(this);

		nameLabel = new ArrayList<>();
		nameLabel.add(new ClassNotableDrawer(obj, panel, WIDTH, HEIGHT, getDiagramPanel()));
		stereotypeLabels = new ArrayList<>();
		methodLabels = new ArrayList<>();
		variableLabels = new ArrayList<>();
		dragging = false;
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
		Storage storage = getDiagramPanel().getStorage();
		for (Notable variable : obj.getInstanceVariables()) {
			if (!hasLabel(variableLabels, variable)) 
				variableLabels.add(new NotableDrawer(variable, new NotableCommand<ObjectClass>(obj, storage::removeObject, storage::addObject), panel, WIDTH, HEIGHT, getDiagramPanel()));
		}
		for (Notable stereotype : obj.getStereotypes()) {
			if (!hasLabel(stereotypeLabels, stereotype)) 
				stereotypeLabels.add(new NotableDrawer(stereotype, new NotableCommand<Notable>(stereotype, obj::removeStereotype, obj::addStereotype), panel, WIDTH, HEIGHT, getDiagramPanel()));
		}
		for (Notable method : obj.getMethods()) {
			if (!hasLabel(methodLabels, method)) 
				methodLabels.add(new NotableDrawer(method, new NotableCommand<Notable>(method, obj::removeMethod, obj::addMethod), panel, WIDTH, HEIGHT, getDiagramPanel()));
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
		currHeight += HEIGHT;
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
				if (arrow.getArrow().getFrom().equals(toDraw.getNotable())) 
					arrow.setFromPosition(new Point((int)clicked.getX() + WIDTH, currHeight + (int)clicked.getY() - (int)(0.5*HEIGHT)));
				if (arrow.getArrow().getTo().equals(toDraw.getNotable())) 
					arrow.setToPosition(new Point((int)clicked.getX(), currHeight + (int)clicked.getY() - (int)(0.5*HEIGHT)));
			}
		}
	}

	/**
	 * Draws the object being represented
	 * @param reference the component being drawn on
	 * @param arrows arrows to associate with parts of the component
	 */
	public void drawShape(JPanel reference, List<ArrowDrawer> arrows) {
		currHeight = 0;
		panel.removeAll();
		Point clicked = obj.getPosition();
		updateLabels();
		drawLabelList(stereotypeLabels, arrows);
		drawLabelList(nameLabel, arrows);
		drawLabelList(variableLabels, arrows);
		drawLabelList(methodLabels, arrows);

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
		oldPosition = obj.getPosition();
		panel.setBorder(BorderFactory.createLineBorder(Color.BLUE));
	}

	/**
	 * Handles Mouse event: Released
	 * @param MouseEvent e
	 */
	public void mouseReleased(MouseEvent e) {
		if (dragging) {
			getDiagramPanel().getCommandHandler().executeCommand(new DragCommand(obj, oldPosition));
			dragging = false;
		}
		panel.setBorder(BorderFactory.createLineBorder(ThemeObject.theme.getBorderColor()));
	}

	/**
	 * Handles Mouse event: Dragged
	 * @param MouseEvent e
	 */
	public void mouseDragged(MouseEvent e) {
		dragging = true;
		int deltaX = e.getXOnScreen() - clickX;
		int deltaY = e.getYOnScreen() - clickY;
		Point prevPos = obj.getPosition();
		Point newPos = new Point((int)prevPos.getX() + deltaX, (int)prevPos.getY() + deltaY);
		obj.setPosition(newPos);
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
