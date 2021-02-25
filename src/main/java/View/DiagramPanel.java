package View;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.Point;
import java.awt.Graphics;
import javax.swing.JPopupMenu;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import java.util.ArrayList;
import java.util.List;

import Document.Storage;
import Document.ObjectClass;
import Document.Arrow;
import View.Listeners.AddClassListener;
import General.Observer;
import View.ArrowSelector;

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

    }

    /**
     * Updates the content of the Diagram
     */
    private void updateView() {
        addComponents();
        removeAll();
        List<Arrow> arrows = Storage.instance.getArrows();
        ArrayList<ArrowDrawer> arrowDrawers = new ArrayList<ArrowDrawer>(arrows.size());
        for (Arrow arrow : arrows) 
            arrowDrawers.add(ArrowFactory.makeArrow(arrow));
        for (ObjectComponent comp : components)
            comp.drawShape(this, arrowDrawers);
        for (ArrowDrawer drawer : arrowDrawers)
            drawer.drawArrow(this);
        repaint();
        revalidate();
    }

    private void addComponents() {
        for (ObjectClass obj : Storage.instance.getObjects()) {
            if (!hasComponent(obj))
                components.add(new ObjectComponent(obj));
        }
    }


    /**
     * Updates when the status of its subjects changes
     */
    public void update() {
        updateView();
    }

    private boolean hasComponent(ObjectClass obj) {
        boolean present = false;
        for (ObjectComponent comp : components) {
            if (comp.equals(obj))
                present = true;
        }
        return present;
    }

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
