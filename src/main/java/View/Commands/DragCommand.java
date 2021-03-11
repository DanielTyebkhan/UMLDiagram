package View.Commands;

import java.awt.Point;

import Document.ObjectClass;
import General.Command;

/**
 * Command to deal with objects being dragged
 * @author Daniel Tyebkhan
 */
public class DragCommand implements Command{
    private Point oldPosition;
    private Point newPosition;
    private ObjectClass object;

    /**
     * Construct a drag command
     * @param object the object being dragged
     * @param oldPosition the objects previous position
     */
    public DragCommand(ObjectClass object, Point oldPosition) {
        this.object = object;
        this.oldPosition = oldPosition;
        this.newPosition = object.getPosition();
    }

    /**
     * Sets the objects position
     */
    @Override
    public void execute() {
        object.setPosition(newPosition);
    }

    /**
     * Resets the object to its previous position
     */
    @Override
    public void unexecute() {
        object.setPosition(oldPosition);
    }
    
}
