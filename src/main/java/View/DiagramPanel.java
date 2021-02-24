package View;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.Point;
import java.awt.Graphics;
import javax.swing.JPopupMenu;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JOptionPane;
import java.util.ArrayList;
import java.util.List;

import Document.Storage;
import Document.ObjectClass;
import Document.Arrow;
import View.Listeners.AddClassListener;
import General.Observer;

/**
 * The main canvas which displays the diagram
 * @author Daniel Tyebkhan
 */
public class DiagramPanel extends JPanel implements MouseListener, Observer {
    private static final String NEW_CLASS = "New Class";

    JPopupMenu rcmenu;
    JMenuItem newObjectItem;

    /**
     * Constructs a diagram panel
     */
    public DiagramPanel() {
        Storage.instance.attachObserver(this);
        rcmenu = new JPopupMenu();
        newObjectItem = new JMenuItem(NEW_CLASS);
        newObjectItem.addMouseListener(new AddClassListener());
        rcmenu.add(newObjectItem);
        addMouseListener(this);
    }

    /**
     * Draws the diagram 
     * @param g the graphics object to draw with
     */
    @Override 
    public void paintComponent(Graphics g) {
        List<Arrow> arrows = Storage.instance.getArrows();
        ArrayList<ArrowDrawer> arrowDrawers = new ArrayList<ArrowDrawer>(arrows.size());
        for (Arrow arrow : arrows) 
            arrowDrawers.add(ArrowFactory.makeArrow(arrow));
        for (ObjectClass obj : Storage.instance.getObjects())
            new ObjectComponent(obj).drawShape(this, arrowDrawers);
        for (ArrowDrawer drawer : arrowDrawers)
            drawer.drawArrow(this);
    }

    /**
     * Updates when the status of its subjects changes
     */
    public void update() {
        repaint();
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
    public void mousePressed(MouseEvent e)
    {
    }

    /**
     * Handles mouse release
     * @param e the trigger
     */
    public void mouseReleased(MouseEvent e) 
    {
     	
    }
}
