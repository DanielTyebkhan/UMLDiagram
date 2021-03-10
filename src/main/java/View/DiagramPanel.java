package View;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.Point;
import java.awt.Graphics;

import javax.swing.JPopupMenu;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import java.util.List;
import java.util.ArrayList;

import Document.Storage;
import Document.ObjectClass;
import Document.Arrow;

import View.Listeners.AddClassListener;
import View.Listeners.AddArrowListener;
import View.ArrowSelector;

import General.Observer;

/**
 * The main canvas which displays the diagram
 * @author Daniel Tyebkhan
 */
public class DiagramPanel extends JPanel implements MouseListener, Observer {
    private static final String NEW_CLASS = "New Class";

    private Point clickLocation;
    private JPopupMenu rcmenu;
    private JMenuItem newObjectItem;
    private ArrayList<ObjectComponent> components;
    private ArrayList<ArrowDrawer> arrowDrawers;

    /**
     * Constructs a diagram panel
     */
    public DiagramPanel() {
        Storage.instance.attachObserver(this);
        rcmenu = new JPopupMenu();
        newObjectItem = new JMenuItem(NEW_CLASS);
        newObjectItem.addActionListener(new AddClassListener(this));
        rcmenu.add(newObjectItem);
        addMouseListener(this);
        this.setLayout(null);
        components = new ArrayList<ObjectComponent>();
        arrowDrawers = new ArrayList<ArrowDrawer>();
        this.setBackground(ThemeObject.theme.getDiagramColor());
    }

    /**
     * Draws the appropriate components
     * @param g the graphics object to draw with
     */
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        addComponents();
        removeClasses();
        removeAll();
        List<Arrow> arrows = Storage.instance.getArrows();
        arrowDrawers = new ArrayList<ArrowDrawer>(arrows.size());
        for (Arrow arrow : arrows) 
            arrowDrawers.add(ArrowFactory.makeArrow(arrow));
        for (ObjectComponent comp : components)
            comp.drawShape(this, arrowDrawers);
        for (ArrowDrawer drawer : arrowDrawers)
            drawer.drawArrow(g);
        revalidate();
    }

    /**
     * Removes classes which are no longer in storage
     */
    private void removeClasses() {
        ArrayList<ObjectComponent> toRemove = new ArrayList<>();
        for (ObjectComponent comp : components) {
            if (!Storage.instance.getObjects().contains(comp.getObject()))
                toRemove.add(comp);
        }
        for (ObjectComponent comp : toRemove)
            components.remove(comp);
    }

    /**
     * Adds components in storage to the diagram
     */
    private void addComponents() {
        for (ObjectClass obj : Storage.instance.getObjects()) {
            if (!hasComponent(obj))
                components.add(new ObjectComponent(obj));
        }
    }


    /**
     * Updates when the status of its subjects changes
     * (See observer interface)
     */
    public void update() {
        repaint();
    }

    /**
     * Checks if there is a component for an ObjectClass
     * @param obj the object to check for
     * @return true if there is a component else false
     */
    private boolean hasComponent(ObjectClass obj) {
        boolean present = false;
        for (ObjectComponent comp : components) {
            if (comp.equals(obj))
                present = true;
        }
        return present;
    }

    /**
     * Gets the location of the last click in the diagram
     * @return the location of the last click
     */
    public Point getClickLocation() {
        return clickLocation;
    }

    /**
     * Handles mouseclicks
     * On right click shows a menu of actions
     * @param e the trigger
     */
	public void mouseClicked(MouseEvent e) {
        if (e.getButton() == MouseEvent.BUTTON3) 
            rcmenu.show(e.getComponent(), e.getX(), e.getY());
	}

    /**
     * Handles mouse entering
     * @param e the trigger
     */
    public void mouseEntered(MouseEvent e)
    {
     	
    }

    /**
     * Handles mouse exiting
     * @param e the trigger
     */
    public void mouseExited(MouseEvent e)
    {
     	
    }

    /**
     * Handles mouse presses
     * @param e the trigger
     */
    public void mousePressed(MouseEvent e) {
        clickLocation = new Point(e.getX(), e.getY());
    }

    /**
     * Handles mouse release
     * @param e the trigger
     */
    public void mouseReleased(MouseEvent e) 
    {
     	
    }
}
