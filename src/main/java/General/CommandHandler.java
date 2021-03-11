package General;

import java.util.Stack;

import Document.Storage;

/**
 * A class to handle commands for do and undo
 * @author Daniel Tyebkhan
 */
public class CommandHandler {
    private Stack<Command> previous;
    private Stack<Command> future;

    /**
     * Constructs a command handler
     */
    public CommandHandler() {
        previous = new Stack<Command>();
        future = new Stack<Command>();
    }

    /**
     * Executes a command 
     * @param command the command to execute
     */
    public void executeCommand(Command command) {
        future.clear();
        executeCommandNoClear(command);
    }

    /**
     * Executes a command without clearing the redo stack
     * @param command the command to execute
     */
    private void executeCommandNoClear(Command command) {
        command.execute();
        previous.push(command);
    }

    /**
     * Undoes the previous command
     */
    public void undo() {
        if (!previous.isEmpty()) {
            Command current = previous.pop();
            current.unexecute();
            future.add(current);
        }
    }

    /**
     * Redoes the last undone command
     */
    public void redo() {
        if (!future.isEmpty()) {
            Command current = future.pop();
            executeCommandNoClear(current);
        }
    }
}
