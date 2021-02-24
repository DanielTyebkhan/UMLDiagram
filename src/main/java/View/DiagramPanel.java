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
 * @author Daniel Tyebkhan
 */
public class DiagramPanel extends JPanel implements MouseListener, Observer {
    private static final String NEW_CLASS = "New Class";

    JPopupMenu rcmenu;
    JMenuItem newObjectItem;

    public DiagramPanel() {
        Storage.instance.attachObserver(this);
        rcmenu = new JPopupMenu();
        newObjectItem = new JMenuItem(NEW_CLASS);
        newObjectItem.addMouseListener(new AddClassListener());
        rcmenu.add(newObjectItem);
        addMouseListener(this);
    }

    @Override 
    public void paintComponent(Graphics g) {
        List<Arrow> arrows = Storage.instance.getArrows();
        ArrayList<ArrowDrawer> arrowDrawers = new ArrayList<ArrowDrawer>(arrows.size());
        for (Arrow arrow : arrows) 
            arrowDrawers.add(ArrowFactory.makeArrow(arrow));
        for (ObjectClass obj : Storage.instance.getObjects())
            new ObjectComponent(obj).drawShape(this);
        for (ArrowDrawer drawer : arrowDrawers)
            drawer.drawArrow(this);
    }

    public void update() {
        repaint();
    }

	public void arrowType() 
	{

	}

	public void drawArrow()
	{

	}

	public void mouseClicked(MouseEvent e) {
        if (e.getButton() == MouseEvent.BUTTON3) 
            rcmenu.show(e.getComponent(), e.getX(), e.getY());
    }

    public void mouseEntered(MouseEvent e)
    {
     	
    }
    public void mouseExited(MouseEvent e)
    {
     	
    }
    public void mousePressed(MouseEvent e)
    {
    }
    public void mouseReleased(MouseEvent e) 
    {
     	
    }
}
