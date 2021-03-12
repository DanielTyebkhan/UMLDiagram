package View.Listeners;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;

import Document.ObjectClass;
import Document.Storage;
import View.DiagramPanel;
import View.Commands.NotableCommand;

/**
 * A listener to add a class to the diagram
 * @author Daniel Tyebkhan
 */
public class AddClassListener extends Listener implements ActionListener {
    private static final String CLASS_NAME_PROMPT = "Enter Class Name";
    
    /**
     * Constructs the listener
     * @param parent the object to draw in
     */
    public AddClassListener(DiagramPanel parent) {
        super(parent);
    }

    /**
     * Prompts the user for a classname then adds the class to the diagram
     * @param e the trigger
     */
    public void actionPerformed(ActionEvent e) {
        String name = JOptionPane.showInputDialog(getPanel(), CLASS_NAME_PROMPT);
        if (name != null && !name.equals(""))
            getPanel().getCommandHandler().executeCommand(new NotableCommand<ObjectClass>(new ObjectClass(name, getPanel().getClickLocation()), Storage.instance::addObject, Storage.instance::removeObject));
    }
}

