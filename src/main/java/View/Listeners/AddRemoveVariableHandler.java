// package View.Listeners;

// import java.awt.event.ActionListener;
// import java.awt.event.ActionEvent;
// import javax.swing.JOptionPane;
// import javax.swing.JPanel;
// import java.util.function.Consumer;

// import Document.Notable;
// import Document.ObjectClass;
// import General.Command;

// /**
//  * Invokes a method on a class with user input 
//  * @author Daniel Tyebkhan 
//  */
// public class AddRemoveVariableHandler implements ActionListener, Command {
// 	private String prompt;
// 	private String name;
// 	private ObjectClass object;
// 	private JPanel parent;
// 	private boolean removes;

// 	/**
// 	 * AddNotableHandler Constructor
// 	 * @param String Prompt
// 	 * @param Consumer<Notable> action
// 	 * @param JPanel panel
// 	 */
// 	public AddRemoveVariableHandler(String prompt, ObjectClass object, JPanel parent, boolean removes) {
// 		this.prompt = prompt;
// 		this.object = object;
// 		this.parent = parent;
// 		this.removes = removes;
// 	}

// 	@Override
// 	public void execute() {
// 		if (parameter) {
// 			if (removes)
// 				parent.removeInstanceVariable(new Notable(name));
// 			else
// 				parent.addInstanceVariable(new Notable(name));
// 		}
// 	}

// 	@Override 
// 	public void unexecute() {
// 		if (parameter) {
// 			if (removes)
// 				parent.addInstanceVariable(new Notable(name));
// 			else
// 				parent.removeInstanceVariable(new Notable(name));
// 		}
// 	}

// 	/**
// 	 * actionPerformed
// 	 * @param ActionEvent e
// 	 */
// 	public void actionPerformed(ActionEvent e) {
// 		String name = JOptionPane.showInputDialog(parent, prompt);
// 		if (name != null && !name.equals(""))
// 			execute();
// 	}
// }
