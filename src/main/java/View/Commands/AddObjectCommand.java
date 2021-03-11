package View.Commands;

import java.awt.Point;

import Document.ObjectClass;
import Document.Storage;
import General.Command;

/**
 * Command to add an object to the diagram
 * @author Daniel Tyebkhan
 */
public class AddObjectCommand implements Command{
    private ObjectClass object;

    /**
     * Constructs a command to add an object
     * @param name the name of the object
     * @param position the initial position of the object
     */
    public AddObjectCommand(String name, Point position) {
        object = new ObjectClass(name, position);
    }

    @Override
    public void execute() {
        Storage.instance.addObject(object);
    }

    @Override
    public void unexecute() {
        Storage.instance.removeObject(object);
    }
}
