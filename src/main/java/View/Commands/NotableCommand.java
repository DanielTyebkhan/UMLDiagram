package View.Commands;

import java.util.function.Consumer;

import Document.Notable;
import General.Command;

/**
 * Removes a variable from an object
 * @author Daniel Tyebkhan
 */
public class NotableCommand implements Command {
    private Notable notable;
    private Consumer<Notable> toExecute;
    private Consumer<Notable> toUnexecute;
    
    public NotableCommand(Notable notable, Consumer<Notable> toExecute, Consumer<Notable> toUnexecute) {
        this.notable = notable;
        this.toExecute = toExecute;
        this.toUnexecute = toUnexecute;
    }

    @Override
    public void execute() {
        toExecute.accept(notable);
    }

    @Override
    public void unexecute() {
        toUnexecute.accept(notable);
    }


}
