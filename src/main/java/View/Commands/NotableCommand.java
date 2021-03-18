package View.Commands;

import java.util.function.Consumer;

import Document.Notable;
import General.Command;

/**
 * Command to perform and undo an action which consumes a notable
 * @author Daniel Tyebkhan
 */
public class NotableCommand<T extends Notable> implements Command {
    private T notable;
    private Consumer<T> toExecute;
    private Consumer<T> toUnexecute;
    
    /**
     * Constructs the command
     * @param notable the notable to pass into the command
     * @param toExecute the command to execute
     * @param toUnexecute the command to unexecute
     */
    public NotableCommand(T notable, Consumer<T> toExecute, Consumer<T> toUnexecute) {
        this.notable = notable;
        this.toExecute = toExecute;
        this.toUnexecute = toUnexecute;
    }

    /**
     * Executes the command
     */
    @Override
    public void execute() {
        toExecute.accept(notable);
    }

    /**
     * Undoes the command
     */
    @Override
    public void unexecute() {
        toUnexecute.accept(notable);
    }
}
