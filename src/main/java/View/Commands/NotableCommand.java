package View.Commands;

import java.util.function.Consumer;

import Document.Notable;
import General.Command;

/**
 * Removes a variable from an object
 * @author Daniel Tyebkhan
 */
public class NotableCommand<T extends Notable> implements Command {
    private T notable;
    private Consumer<T> toExecute;
    private Consumer<T> toUnexecute;
    
    public NotableCommand(T notable, Consumer<T> toExecute, Consumer<T> toUnexecute) {
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
