package View;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.Point;
import javax.swing.JPopupMenu;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JOptionPane;

import Document.Storage;
import Document.ObjectClass;
import General.Observer;

/**
 * @author Daniel Tyebkhan
 */
public class DiagramPanel extends JPanel implements MouseListener, Observer {
    private static final String NEW_CLASS = "New Class";
    private static final String CLASS_NAME_PROMPT = "Enter Class Name";

    JPopupMenu rcmenu;
    JMenuItem newObjectItem;

    public DiagramPanel() {
        Storage.instance.addObserver(this);
        rcmenu = new JPopupMenu();
        newObjectItem = new JMenuItem(NEW_CLASS);
        newObjectItem.addMouseListener(new ObjectItemListener());
        rcmenu.add(newObjectItem);
        addMouseListener(this);
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
        
            System.out.println("Clicked");
	 	
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

    private class ObjectItemListener implements MouseListener {
        public void mouseClicked(MouseEvent e) {
            String name = JOptionPane.showInputDialog(this, CLASS_NAME_PROMPT);
            if (name != null || !name.equals("")) 
                Storage.instance.addObject(new ObjectClass(name, new Point(e.getPoint())));
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
    
}
