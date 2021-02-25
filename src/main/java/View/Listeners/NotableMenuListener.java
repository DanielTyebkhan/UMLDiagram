package View.Listeners;

import javax.swing.JPopupMenu;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseEvent;
import java.util.function.Consumer;

import Document.Notable;

/**
 * @author Daniel Tyebkhan
 */
public class NotableMenuListener implements MouseListener, MouseMotionListener {
    private static final String DELETE = "Delete";
    private static final String RENAME = "Rename";
    
    private Notable notable;
    private JPopupMenu menu;
    private Consumer<Notable> remover;
    private JPanel parent;
    
    public NotableMenuListener(Notable notable, Consumer<Notable> remover, JPanel parent) {
        this.notable = notable;
        this.remover = remover;
        this.parent = parent;
        menu = new JPopupMenu();
        JMenuItem delete = new JMenuItem(DELETE);
        delete.addActionListener(new RemoveHandler(notable, remover));
    }

    public void mouseClicked(MouseEvent e) {
        if (e.getButton() == MouseEvent.BUTTON3) {
            menu.show(parent, e.getX(), e.getY());
            System.out.println(parent);
        }
        else
            parent.dispatchEvent(e);
    }

    public void mousePressed(MouseEvent e) {
        parent.dispatchEvent(e);
    }

    public void mouseReleased(MouseEvent e) {
        parent.dispatchEvent(e);
    }

    public void mouseEntered(MouseEvent e) {
        parent.dispatchEvent(e);
    }

    public void mouseExited(MouseEvent e) {
        parent.dispatchEvent(e);
    }

    public void mouseMoved(MouseEvent e) {
        parent.dispatchEvent(e);
    }

    public void mouseDragged(MouseEvent e) {
        parent.dispatchEvent(e);
    }
}