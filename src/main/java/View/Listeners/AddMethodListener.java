package View.Listeners;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;

import Document.Method;
import Document.ObjectClass;
import View.DiagramMember;
import View.DiagramPanel;
import View.Commands.NotableCommand;

/**
 * A listener to add a methods to the diagram
 * @author Daniel Tyebkhan
 */
public class AddMethodListener extends DiagramMember implements ActionListener {
    private static final String METHOD_NAME_PROMPT = "Enter Method Name";
    private ObjectClass object;
    /**
     * Constructs the listener
     * @param parent the object to draw in
     */
    public AddMethodListener(ObjectClass object, DiagramPanel parent) {
        super(parent);
        this.object = object;
    }

    /**
     * Prompts the user for a method name then adds the method
     * @param e the trigger
     */
    public void actionPerformed(ActionEvent e) {
        String name = JOptionPane.showInputDialog(getDiagramPanel(), METHOD_NAME_PROMPT);
        if (name != null && !name.equals(""))
            getDiagramPanel().getCommandHandler().executeCommand(new NotableCommand<Method>(new Method(name), object::addMethod, object::removeMethod));
    }
}
