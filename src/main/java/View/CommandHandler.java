package View;

import java.util.Stack;

import General.Command;

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
        Command current = previous.pop();
        current.unexecute();
        future.add(current);
    }

    /**
     * Redoes the last undone command
     */
    public void redo() {
        Command current = future.pop();
        executeCommand(current);
    }
}
