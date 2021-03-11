package View.Commands;

import java.awt.Point;

import Document.ObjectClass;
import Document.Storage;
import General.Command;

public class AddObjectCommand implements Command{
    private ObjectClass object;

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
