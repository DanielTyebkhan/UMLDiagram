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
public class AddNotableListener extends DiagramMember implements ActionListener {
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
	public AddNotableListener(String prompt, Consumer<Notable> action, Consumer<Notable> unaction, JPanel parent, DiagramPanel diagramPanel) {
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
			getDiagramPanel().getCommandHandler().executeCommand(new NotableCommand<Notable>(new Notable(name), action, unaction));
	}
}
