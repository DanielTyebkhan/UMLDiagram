package View.Listeners;

import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import java.awt.event.ActionEvent;

import Document.Method;
import View.DiagramMember;
import View.DiagramPanel;
import View.Commands.NotableCommand;

public class AddParameterListener extends DiagramMember implements ActionListener {
    private static final String PARAM_NAME = "Enter Parameter Name";

    private Method method;

    public AddParameterListener(Method method, DiagramPanel panel) {
        super(panel);
        this.method = method;
    }

    @Override
	public void actionPerformed(ActionEvent e) {
		String name = JOptionPane.showInputDialog(getDiagramPanel(), PARAM_NAME);
		if (name != null && !name.equals(""))
			getDiagramPanel().getCommandHandler().executeCommand(new NotableCommand<Method>(new Method(name), method::addParameter, method::removeParameter));
	}

}
