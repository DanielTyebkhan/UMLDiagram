package View.Commands;

import Document.Notable;
import Document.ObjectClass;
import General.Command;

public class RemoveVariableCommand implements Command {
    private Notable variable;
    private ObjectClass object;
    
    public RemoveVariableCommand(ObjectClass object, Notable variable) {
        this.object = object;
        this.variable = variable;
    }

    @Override
    public void execute() {
        object.removeInstanceVariable(variable);
    }

    @Override
    public void unexecute() {
        object.addInstanceVariable(variable);
    }


}
