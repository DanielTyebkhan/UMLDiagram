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
import View.ArrowDrawer;
import Document.Arrow;
/**
 * @author Daniel Tyebkhan
 */
public class NotableDrawer {
    private static final int FONT_SIZE = 12;
    private static final String FONT_NAME = "Calibri";
    private Notable notable;
    private JLabel label;
    private JPanel parent;

    public NotableDrawer(Notable notable, Consumer<Notable> remover, JPanel parent, int width, int height, boolean bold) {
        this.notable = notable;
        this.parent = parent;

        label = new JLabel(notable.getName());
        label.setPreferredSize(new Dimension(width, height));
        label.setMaximumSize(new Dimension(width, height));
        label.setBorder(BorderFactory.createLineBorder(Color.black));
        label.setFont(new Font(FONT_NAME, bold ? Font.BOLD : Font.PLAIN, FONT_SIZE));
        //label.addMouseListener(new NotableMenuListener(notable, remover, parent));
    }

    public NotableDrawer(Notable notable, Consumer<Notable> remover, JPanel parent, int width, int height) {
        this(notable, remover, parent, width, height, false);
    }

    public void draw() {
        label.setText(notable.getName());
        parent.add(label);
    }

    public Notable getNotable() {
        return notable;
    }
}
        

