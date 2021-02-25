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
import View.Listeners.AddNotableHandler;
import View.Listeners.NotableMenuListener;
import View.Listeners.RemoveHandler;
import View.Listeners.AddArrowListener;
import View.ArrowDrawer;
import Document.Arrow;

/**
 * @author Daniel Tyebkhan
 */
public class NotableDrawer implements MouseListener, MouseMotionListener {
    protected static final int FONT_SIZE = 12;
    protected static final String FONT_NAME = "Calibri";
    protected static final String DELETE = "Delete";
    protected static final String ADD_ARROW = "Add Arrow From";
    protected Notable notable;
    protected JLabel label;
    protected JPanel parent;
    protected JPopupMenu menu;

    public NotableDrawer(Notable notable, Consumer<Notable> remover, JPanel parent, int width, int height) {
        this.notable = notable;
        this.parent = parent;
        
        menu = new JPopupMenu();
        JMenuItem deleteItem = new JMenuItem(DELETE);
        JMenuItem addArrow = new JMenuItem(ADD_ARROW);
        deleteItem.addActionListener(new RemoveHandler(notable, remover));
        addArrow.addActionListener(new AddArrowListener(getNotable()));
        menu.add(deleteItem);
        menu.add(addArrow);
        label = new JLabel(notable.getName());
        label.setPreferredSize(new Dimension(width, height));
        label.setMaximumSize(new Dimension(width, height));
        label.setBorder(BorderFactory.createLineBorder(Color.black));
        label.setFont(new Font(FONT_NAME, Font.PLAIN, FONT_SIZE));
        label.addMouseListener(this);
        label.addMouseMotionListener(this);
    }

    public void draw() {
        label.setText(notable.getName());
        parent.add(label);
    }

    public Notable getNotable() {
        return notable;
    }

    public void mouseClicked(MouseEvent e) {
        if (e.getButton() == MouseEvent.BUTTON3) {
            menu.show(parent, e.getX(), e.getY());
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
        

