package View.Commands;

import java.util.ArrayList;

import Document.Arrow;
import Document.Storage;
import Document.ObjectClass;

import General.Command;

/**
 * Command to remove an object
 * @author Daniel Tyebkhan
 */
public class RemoveObjectCommand implements Command {
    private ObjectClass object;
    private ArrayList<Arrow> arrows;
    private Storage storage;

    /**
     * Constructs the command
     * @param storage the storage to remove from
     * @param object the object to remove
     */
    public RemoveObjectCommand(Storage storage, ObjectClass object) {
        this.storage = storage;
        this.object = object;
        arrows = new ArrayList<Arrow>();
    }

    /**
     * Removes the object and all associated arrows from storage
     */
    @Override
    public void execute() {
        for (Arrow arrow : storage.getArrows()) {
            if (arrow.getFrom().equals(object) || arrow.getTo().equals(object)) 
                arrows.add(arrow);
        }
        storage.removeObject(object);
    }

    /**
     * Adds the object and all associated arrows to storage
     */
    @Override
    public void unexecute() {
        storage.addObject(object);
        for (Arrow arrow : arrows) {
            if (!storage.getArrows().contains(arrow))
                storage.addArrow(arrow);
        }
    }
}