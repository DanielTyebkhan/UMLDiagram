package General;

/**
 * Defines a command
 */
public interface Command {

	/**
	 * Executes the command
	 */
	public void execute();

	/**
	 * Undoes the command
	 */
	public void unexecute();
}