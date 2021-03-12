package View;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
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
import View.Arrows.ArrowDrawer;
import View.Arrows.ArrowFactory;
import View.Listeners.AddClassListener;
import General.CommandHandler;
import General.Observer;

/**
 * The main canvas which displays the diagram
 * @author Daniel Tyebkhan
 */
public class DiagramPanel extends JPanel implements MouseListener, Observer, KeyListener {

    private static final String NEW_CLASS = "New Class";

    private Storage storage;
    private Point clickLocation;
    private JPopupMenu rcmenu;
    private JMenuItem newObjectItem;
    private ArrayList<ObjectComponent> components;
    private ArrayList<ArrowDrawer> arrowDrawers;
    private CommandHandler commandHandler;
    private boolean controlMod;

    /**
     * Constructs a diagram panel
     */
    public DiagramPanel() {
        storage = new Storage();
        storage.attachObserver(this);
        commandHandler = new CommandHandler();
        controlMod = false;
        rcmenu = new JPopupMenu();
        newObjectItem = new JMenuItem(NEW_CLASS);
        newObjectItem.addActionListener(new AddClassListener(this));
        rcmenu.add(newObjectItem);
        addMouseListener(this);
        addKeyListener(this);
        this.setLayout(null);
        components = new ArrayList<ObjectComponent>();
        arrowDrawers = new ArrayList<ArrowDrawer>();
        this.setBackground(ThemeObject.theme.getDiagramColor());
    }

    public CommandHandler getCommandHandler() {
        return commandHandler;
    }

    /**
     * Draws the appropriate components
     * @param g the graphics object to draw with
     */
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        requestFocus();
        addComponents();
        removeClasses();
        removeAll();
        List<Arrow> arrows = storage.getArrows();
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
            if (!storage.getObjects().contains(comp.getObject()))
                toRemove.add(comp);
        }
        for (ObjectComponent comp : toRemove)
            components.remove(comp);
    }

    /**
     * Adds components in storage to the diagram
     */
    private void addComponents() {
        for (ObjectClass obj : storage.getObjects()) {
            if (!hasComponent(obj))
                components.add(new ObjectComponent(this, obj));
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
        requestFocus();
        clickLocation = new Point(e.getX(), e.getY());
    }

    /**
     * Handles mouse release
     * @param e the trigger
     */
    public void mouseReleased(MouseEvent e) 
    {
     	
    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case 17:
                controlMod = true;
                break;
            case 90:
                if (controlMod)
                    commandHandler.undo();
                break;
            case 89:
                if (controlMod)
                    commandHandler.redo();
                break;
            default:
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        switch (e.getKeyCode()) {
            case 17:
                controlMod = false;
                break;
            default:
                break;
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        
    }
}
