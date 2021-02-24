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
* @author Daniel Tyebkhan
*/
public class ObjectComponent implements MouseListener, MouseMotionListener {
    private static final String NEW_METHOD = "Add Method";
    private static final String NEW_VARIABLE = "Add Variable";
    private static final String NEW_STEREOTYPE = "Add Stereotype";
    private static final String ENT_METHOD_NAME = "Enter Method Name";
    private static final String ENT_VARIABLE_NAME = "Enter Variable Name";
    private static final String ENT_STEREOTYPE_NAME = "Enter Stereotype Name";
    private static final String STER_START = "<<";
    private static final String STER_END = ">>";
    private static final String FONT_NAME = "Calibri";
	private static final int HEIGHT = 30;
	private static final int WIDTH  = 100;
    private static final int FONT_SIZE = 12;
	private ObjectClass obj;
	private JPanel panel;
    private JPopupMenu rcmenu;
    private JMenuItem newMethod;
    private JMenuItem newVariable;
    private JMenuItem newStereotype;
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
        newMethod = new JMenuItem(NEW_METHOD);
        newVariable = new JMenuItem(NEW_VARIABLE);
        newStereotype = new JMenuItem(NEW_STEREOTYPE);
        newMethod.addActionListener(new AddNotableHandler(ENT_METHOD_NAME, obj::addMethod, panel));
        newVariable.addActionListener(new AddNotableHandler(ENT_VARIABLE_NAME, obj::addInstanceVariable, panel));
        newStereotype.addActionListener(new AddNotableHandler(ENT_STEREOTYPE_NAME, obj::addStereotype, panel));
        rcmenu.add(newMethod);
        rcmenu.add(newVariable);
        rcmenu.add(newStereotype);
    }

    public ObjectClass getObject() {
        return obj;
    }

	private void addLabel(String text) {
        addLabel(text, false);
    }

	private void addLabel(String text, boolean bold) {
		JLabel label = new JLabel(text);
	 	label.setPreferredSize(new Dimension(WIDTH, HEIGHT));
	 	label.setMaximumSize(new Dimension(WIDTH, HEIGHT));
	 	label.setBorder(BorderFactory.createLineBorder(Color.black));
        label.setFont(new Font(FONT_NAME, bold ? Font.BOLD : Font.PLAIN, FONT_SIZE));
	 	incrementHeight();
	 	incrementWidth();
        panel.add(label);
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

    private String Stereotypify(String stereotype) {
        return STER_START + stereotype + STER_END; 
    }

	public void drawShape(JPanel reference, List<ArrowDrawer> arrows) {
        panel.removeAll();
		Point clicked = obj.getPosition();
        for (Notable stereotype : obj.getStereotypes()) {
            addLabel(Stereotypify(stereotype.getName()));
        }
        addLabel(obj.getName(), true);
		for (Notable method : obj.getMethods()) {
			addLabel(method.getName());
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
            addLabel(variable.getName());
			for (ArrowDrawer arrow : arrows) {
				if ( arrow.getArrow().getFrom().equals(variable)) {
				// arrow.setFromPosition(point);
				}
			}
		}
		Dimension dimension = reference.getSize();
		Dimension size = panel.getPreferredSize();
		panel.setBounds((int)clicked.getX(),(int)clicked.getY(), size.width , size.height);
		reference.add(panel);

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
        Point prevPos = obj.getPosition();
        obj.setPosition(new Point((int)prevPos.getX() + deltaX, (int)prevPos.getY() + deltaY));
        clickX = e.getXOnScreen();
        clickY = e.getYOnScreen();
    }

    public void mouseMoved(MouseEvent e) {

    }
    
}
