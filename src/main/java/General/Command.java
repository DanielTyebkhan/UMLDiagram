package General;

/**
 * Defines a command
 */
public interface Command {
	public void execute();

	public void unexecute();
}