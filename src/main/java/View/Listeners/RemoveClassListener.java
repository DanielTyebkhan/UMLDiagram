package View.Listeners;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import Document.ObjectClass;
import Document.Storage;
import View.DiagramPanel;
import View.Commands.ObjectCommand;

/**
 * A listener to add a class to the diagram
 * @author Daniel Tyebkhan
 */
public class RemoveClassListener extends Listener implements ActionListener {
    private ObjectClass object;

    public RemoveClassListener(DiagramPanel panel, ObjectClass object) {
        super(panel);
        this.object = object;
    }

    /**
     * Prompts the user for a classname then adds the class to the diagram
     * @param e the trigger
     */
    public void actionPerformed(ActionEvent e) {
        getPanel().getCommandHandler().executeCommand(new ObjectCommand(object, Storage.instance::removeObject, Storage.instance::addObject));
    }
}


