package View.Listeners;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.util.function.Consumer;

import Document.Notable;

/**
 * Removes a notable based on a given method 
 * @author Daniel Tyebkhan 
 */
public class RemoveHandler implements ActionListener {
    private Notable toRemove;
    private Consumer<Notable> action;

    public RemoveHandler(Notable toRemove, Consumer<Notable> action, JPanel parent) {
        this.toRemove = toRemove;
        this.action = action;
    }
    
    public void actionPerformed(ActionEvent e) {
        action.accept(toRemove);
    }
}
