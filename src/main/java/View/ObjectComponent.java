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
import Document.Storage;
import View.Listeners.AddClassListener;
import View.Listeners.AddNotableHandler;
import View.Listeners.NotableMenuListener;
import View.Listeners.RemoveHandler;
import View.ArrowDrawer;
import View.NotableDrawer;
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
    private static final String DELETE = "Delete";
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
    private JMenuItem delete;
	private int incHeight = 0;
	private int incWidth = 0;
    private boolean selected;
    private int clickX;
    private int clickY;
    private ArrayList<NotableDrawer> stereotypeLabels;
    private ArrayList<NotableDrawer> methodLabels;
    private ArrayList<NotableDrawer> variableLabels;
    private ArrayList<NotableDrawer> nameLabel;

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
        delete = new JMenuItem(DELETE);
        delete.addActionListener(new RemoveHandler(obj, Storage.instance::removeObject));
        rcmenu.add(newMethod);
        rcmenu.add(newVariable);
        rcmenu.add(newStereotype);
        rcmenu.add(delete);

        nameLabel = new ArrayList<>();
        nameLabel.add(new NotableDrawer(obj, Storage.instance::removeObject, panel, WIDTH, HEIGHT, true));
        stereotypeLabels = new ArrayList<>();
        methodLabels = new ArrayList<>();
        variableLabels = new ArrayList<>();
    }

    public ObjectClass getObject() {
        return obj;
    }

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

    private boolean hasLabel(ArrayList<NotableDrawer> labels, Notable nble) {
        boolean present = false;
        for (NotableDrawer d : labels) {
            if (d.getNotable().equals(nble))
                present = true;
        }
        return present;
    }

	private void incrementHeight() {
		incHeight += HEIGHT;
	}

	private void incrementWidth() {
		incWidth += WIDTH;
	}

    private void drawLabelList(List<NotableDrawer> list, List<ArrowDrawer> arrows) {
        Point clicked = obj.getPosition();
        for (NotableDrawer toDraw : list) {
            toDraw.draw();
            incrementHeight();
            for (ArrowDrawer arrow : arrows) {
                if (arrow.getArrow().getFrom().equals(toDraw.getNotable())) {
                    arrow.setFromPosition(new Point((int)clicked.getX() + incWidth, HEIGHT + (1/2) *(incHeight) + (int)clicked.getY()));
                    System.out.println("arrowFrom");
                }
                if (arrow.getArrow().getTo().equals(toDraw.getNotable())) {
                    arrow.setToPosition(new Point((int)clicked.getX(), HEIGHT + (1/2) *(incHeight) + (int)clicked.getY()));
                    System.out.println("arrowto");
                }
            }
        }
    }

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
