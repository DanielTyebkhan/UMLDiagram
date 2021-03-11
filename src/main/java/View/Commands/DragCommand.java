package View.Commands;

import java.awt.Point;

import Document.ObjectClass;
import General.Command;

public class DragCommand implements Command{
    private Point oldPosition;
    private Point newPosition;
    private ObjectClass object;

    public DragCommand(ObjectClass object, Point oldPosition) {
        this.object = object;
        this.oldPosition = oldPosition;
        this.newPosition = object.getPosition();
    }

    @Override
    public void execute() {
        object.setPosition(newPosition);
    }

    @Override
    public void unexecute() {
        object.setPosition(oldPosition);
    }
    
}
