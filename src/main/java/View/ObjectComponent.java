package View;


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import Document.ObjectClass;
import Document.Notable;
import View.Listeners.AddClassListener;
import View.Listeners.AddNotableHandler;
import View.ArrowDrawer;
import Document.Arrow;

/**
* @author Anhad Gande
*/

public class ObjectComponent implements MouseListener, MouseMotionListener {
	private static final int HEIGHT = 30;
	private static final int WIDTH  = 100;
	private ObjectClass obj;
	private JPanel panel;
	JPopupMenu rcmenu;
	JMenuItem newMethod;
	JMenuItem newVariable;
	private int incHeight = 0;
	private int incWidth = 0;
    private boolean selected;
    private int clickX;
    private int clickY;

	public ObjectComponent(ObjectClass obj) {
	 	 this.obj = obj;
	 	 panel = new JPanel();
	 	 panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));

	 	 panel.setBorder(BorderFactory.createLineBorder(Color.black));
         panel.addMouseListener(this);
         panel.addMouseMotionListener(this);

	 	 rcmenu = new JPopupMenu();
	 	 newMethod = new JMenuItem("New Method");
	 	 newVariable = new JMenuItem("New Variable");
         newMethod.addActionListener(new AddNotableHandler("Enter method name", obj::addMethod, panel));
         newVariable.addActionListener(new AddNotableHandler("Enter variable name", obj::addInstanceVariable, panel));
         rcmenu.add(newMethod);
         rcmenu.add(newVariable);
	 }

    public ObjectClass getObject() {
        return obj;
    }

	private JLabel addLabel(String text) {
		JLabel label = new JLabel(text);

	 	label.setPreferredSize(new Dimension(WIDTH, HEIGHT));
	 	label.setMaximumSize(new Dimension(WIDTH, HEIGHT));
	 	label.setBorder(BorderFactory.createLineBorder(Color.black));
	 	incrementHeight();
	 	incrementWidth();
	 	return label;
	}
	private void incrementHeight() {
		incHeight += HEIGHT;
	}
	private void incrementWidth() {
		incWidth += WIDTH;
	}
	/**
	* Adds a class name to the class diagram
	*/
	public void addName(String name) {
		obj.setName(name);
	}
	/**
	* Adds a method to the class diagram
	*/
	public void addMethod(String method) {
		obj.addMethod(new Notable(method));
	}
	/**
	* Removes a method from the class diagram
	*/
	public void removeMethod(String method) {
		obj.removeMethod(new Notable(method));
	}
	public void addVariable(String var) {
		obj.addInstanceVariable(new Notable(var));
	}
	public void removeVariable(String var) {
		obj.removeInstanceVariable(new Notable(var));
	}

	public void drawShape(JPanel reference, List<ArrowDrawer> arrows) {
        panel.removeAll();
        panel.add(addLabel(obj.getName()));
		Point clicked = obj.getPosition();
		for (Notable method : obj.getMethods()) {
			panel.add(addLabel(method.getName()));
			for (ArrowDrawer arrow : arrows) {
				if ( arrow.getArrow().getFrom().equals(method)) {
				    arrow.setFromPosition(new Point((int)clicked.getX() + incWidth, HEIGHT + (1/2) *(incHeight) + (int)clicked.getY()));
				}
				if ( arrow.getArrow().getTo().equals(method)) {
				    arrow.setFromPosition(new Point((int)clicked.getX(), HEIGHT + (1/2) *(incHeight) + (int)clicked.getY()));
				}
			}
		}
		for (Notable variable : obj.getInstanceVariables()) {
			panel.add(new JLabel(variable.getName()));
			for (ArrowDrawer arrow : arrows) {
				if ( arrow.getArrow().getFrom().equals(variable)) {
				// arrow.setFromPosition(point);
				}
			}
		}
		Dimension dimension = reference.getSize();
		System.out.println(clicked.getX());
		System.out.print(clicked.getY());
		// System.out.println(dimension);
		Dimension size = panel.getPreferredSize();
		panel.setBounds((int)clicked.getX(),(int)clicked.getY(), size.width , size.height);
		reference.add(panel);
		// reference.add(listScrollPane, BorderLayout.CENTER);

	}
	public void mouseClicked(MouseEvent e) {
		if(e.getButton() == MouseEvent.BUTTON3) {
			rcmenu.show(panel, e.getX(), e.getY());
		}
	}
	public void mouseEntered(MouseEvent e) {

	}

	public void mouseExited(MouseEvent e) {

	}
	public void mousePressed(MouseEvent e) {
        clickX = e.getXOnScreen();
        clickY = e.getYOnScreen();
        selected = true;
        panel.setBorder(BorderFactory.createLineBorder(Color.blue));

	}
	public void mouseReleased(MouseEvent e) {
        selected = false;
        panel.setBorder(BorderFactory.createLineBorder(Color.black));
	}

    public void mouseDragged(MouseEvent e) {
        int deltaX = e.getXOnScreen() - clickX;
        int deltaY = e.getYOnScreen() - clickY;
        System.out.println("Delta x: " + deltaX);
        System.out.println("Delta y: " + deltaY);
        Point prevPos = obj.getPosition();
        obj.setPosition(new Point((int)prevPos.getX() + deltaX, (int)prevPos.getY() + deltaY));
        clickX = e.getXOnScreen();
        clickY = e.getYOnScreen();
    }

    public void mouseMoved(MouseEvent e) {

    }
    
}
