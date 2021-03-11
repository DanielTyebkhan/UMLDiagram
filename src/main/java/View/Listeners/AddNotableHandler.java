package View.Listeners;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.util.function.Consumer;

import Document.Notable;
import View.DiagramPanel;
import View.Commands.NotableCommand;

/**
 * Invokes a method on a class with user input 
 * @author Daniel Tyebkhan 
 */
public class AddNotableHandler extends Listener implements ActionListener {
	private String prompt;
	private Consumer<Notable> action;
	private Consumer<Notable> unaction;
	private JPanel parent;

	/**
	 * AddNotableHandler Constructor
	 * @param String Prompt
	 * @param Consumer<Notable> action
	 * @param JPanel panel
	 */
	public AddNotableHandler(String prompt, Consumer<Notable> action, Consumer<Notable> unaction, JPanel parent, DiagramPanel diagramPanel) {
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
			getPanel().getCommandHandler().executeCommand(new NotableCommand(new Notable(name), action, unaction));
			action.accept(new Notable(name));
	}
}
