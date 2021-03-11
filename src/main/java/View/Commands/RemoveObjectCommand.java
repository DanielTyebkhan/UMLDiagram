package View.Commands;

import Document.ObjectClass;
import Document.Storage;
import General.Command;

/**
 * Command to add an object to the diagram
 * @author Daniel Tyebkhan
 */
public class RemoveObjectCommand implements Command{
    private ObjectClass object;

    /**
     * Constructs a command to add an object
     * @param name the name of the object
     * @param position the initial position of the object
     */
    public RemoveObjectCommand(ObjectClass object) {
        this.object = object;
    }

    @Override
    public void execute() {
        Storage.instance.removeObject(object);
    }

    @Override
    public void unexecute() {
        Storage.instance.addObject(object);
    }
}

