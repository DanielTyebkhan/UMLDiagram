package View.Listeners;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.util.function.Consumer;

import Document.Notable;
import View.DiagramMember;
import View.DiagramPanel;
import View.Commands.NotableCommand;

/**
 * Invokes a method on a class with user input 
 * @author Daniel Tyebkhan 
 */
public class AddNotableListener<T extends Notable> extends DiagramMember implements ActionListener {
	private String prompt;
	private Consumer<T> action;
	private Consumer<T> unaction;
	private JPanel parent;

	/**
	 * AddNotableHandler Constructor
	 * @param String Prompt
	 * @param Consumer<T> action
	 * @param JPanel panel
	 */
	public AddNotableListener(String prompt, Consumer<T> action, Consumer<T> unaction, JPanel parent, DiagramPanel diagramPanel) {
		super(diagramPanel);
		this.prompt = prompt;
		this.action = action;
		this.unaction = unaction;
		this.parent = parent;
	}
	
	/**
	 * actionPerformed
	 * @param ActionEvent e
	 */
	public void actionPerformed(ActionEvent e) {
		String name = JOptionPane.showInputDialog(parent, prompt);
		if (name != null && !name.equals(""))
			getDiagramPanel().getCommandHandler().executeCommand(new NotableCommand<T>((T) new Notable(name), action, unaction));
	}
}
