package View.Commands;

import java.util.function.Consumer;

import Document.ObjectClass;
import General.Command;

/**
 * Handles operations of ObjectClasses
 * @author Daniel Tyebkhan
 */
public class ObjectCommand implements Command {
    private ObjectClass object;
    private Consumer<ObjectClass> toRun;
    private Consumer<ObjectClass> unRun;

    public ObjectCommand(ObjectClass object, Consumer<ObjectClass> toRun, Consumer<ObjectClass> unRun) {
        this.object = object;
        this.toRun = toRun;
        this.unRun = unRun;
    }

    @Override
    public void execute() {
        toRun.accept(object);
    }

    @Override
    public void unexecute() {
        unRun.accept(object);
    }


    

}
