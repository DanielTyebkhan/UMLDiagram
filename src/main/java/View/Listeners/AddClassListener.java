package View.Listeners;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;

import Document.ObjectClass;
import Document.Storage;
import View.DiagramPanel;
import View.Commands.ObjectCommand;

/**
 * A listener to add a class to the diagram
 * @author Daniel Tyebkhan
 */
public class AddClassListener implements ActionListener {
    private static final String CLASS_NAME_PROMPT = "Enter Class Name";
    
    private DiagramPanel parent;

    /**
     * Constructs the listener
     * @param parent the object to draw in
     */
    public AddClassListener(DiagramPanel parent) {
        this.parent = parent;
    }

    /**
     * Prompts the user for a classname then adds the class to the diagram
     * @param e the trigger
     */
    public void actionPerformed(ActionEvent e) {
        String name = JOptionPane.showInputDialog(parent, CLASS_NAME_PROMPT);
        if (name != null && !name.equals(""))
            parent.getCommandHandler().executeCommand(new ObjectCommand(new ObjectClass(name, parent.getClickLocation()), Storage.instance::addObject, Storage.instance::removeObject));
    }
}

