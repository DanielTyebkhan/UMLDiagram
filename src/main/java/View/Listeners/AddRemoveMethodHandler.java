// package View.Listeners;

// import java.awt.event.ActionListener;
// import java.awt.event.ActionEvent;
// import javax.swing.JOptionPane;
// import javax.swing.JPanel;
// import java.util.function.Consumer;

// import Document.ObjectClass;
// import General.Command;

// /**
//  * Invokes a method on a class with user input 
//  * @author Daniel Tyebkhan 
//  */
// public class AddRemoveMethodHandler implements ActionListener, Command {
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
// 	public AddRemoveMethodHandler(String prompt, ObjectClass object, JPanel parent, boolean removes) {
// 		this.prompt = prompt;
// 		this.object = object;
// 		this.parent = parent;
// 		this.removes = removes;
// 	}

// 	@Override
// 	public void execute() {
// 		if (name) {
// 			if (removes)
// 				parent.removeInstanceVariable(new Method(name));
// 			else
// 				parent.addInstanceVariable(new Method(name));
// 		}
// 	}

// 	@Override 
// 	public void unexecute() {
// 		if (name) {
// 			if (removes)
// 				parent.addInstanceVariable(new Method(name));
// 			else
// 				parent.removeInstanceVariable(new Method(name));
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
