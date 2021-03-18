package View.Commands;

import java.util.ArrayList;

import Document.Arrow;
import Document.Storage;
import Document.ObjectClass;

import General.Command;

public class RemoveObjectCommand implements Command {
    private ObjectClass object;
    private ArrayList<Arrow> arrows;
    private Storage storage;

    public RemoveObjectCommand(Storage storage, ObjectClass object) {
        this.storage = storage;
        this.object = object;
        arrows = new ArrayList<Arrow>();
    }

    @Override
    public void execute() {
        for (Arrow arrow : storage.getArrows()) {
            if (arrow.getFrom().equals(object) || arrow.getTo().equals(object)) 
                arrows.add(arrow);
        }
        storage.removeObject(object);
    }

    @Override
    public void unexecute() {
        storage.addObject(object);
        for (Arrow arrow : arrows) {
            if (!storage.getArrows().contains(arrow))
                storage.addArrow(arrow);
        }
    }
}