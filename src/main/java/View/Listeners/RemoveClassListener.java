package View.Listeners;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import Document.ObjectClass;
import Document.Storage;
import View.DiagramMember;
import View.DiagramPanel;
import View.Commands.NotableCommand;

/**
 * A listener to add a class to the diagram
 * @author Daniel Tyebkhan
 */
public class RemoveClassListener extends DiagramMember implements ActionListener {
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
        getDiagramPanel().getCommandHandler().executeCommand(new NotableCommand<ObjectClass>(object, getDiagramPanel().getStorage()::removeObject, getDiagramPanel().getStorage()::addObject));
    }
}


