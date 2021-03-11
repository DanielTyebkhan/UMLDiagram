package View.Commands;

import java.util.function.Consumer;

import Document.ObjectClass;
import General.Command;

public class ClassCommand implements Command {
    private ObjectClass object;
    private Consumer<ObjectClass> toExecute;
    private Consumer<ObjectClass> toUnexecute;

    public ClassCommand(ObjectClass object, Consumer<ObjectClass> toExecute,  Consumer<ObjectClass> toUnexecute){
        this.object = object;
        this.toExecute = toExecute;
        this.toUnexecute = toUnexecute;
    }

    @Override
    public void execute() {
        toExecute.accept(object);
    }

    @Override
    public void unexecute() {
        toUnexecute.accept(object);
    }
}
