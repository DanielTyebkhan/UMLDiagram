package View.Listeners;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.util.function.Consumer;

import Document.Notable;

/**
 * Invokes a method on a class with user input 
 * @author Daniel Tyebkhan 
 */
public class AddEditNotable implements ActionListener {
    private String prompt;
    private Consumer<Notable> action;
    private JPanel parent;

    public AddEditNotable(String prompt, Consumer<Notable> action, JPanel parent) {
        this.prompt = prompt;
        this.action = action;
        this.parent = parent;
    }
    
    public void actionPerformed(ActionEvent e) {
        String name = JOptionPane.showInputDialog(parent, prompt);
        if (name != null && !name.equals(""))
            action.accept(new Notable(name));
    }
}
