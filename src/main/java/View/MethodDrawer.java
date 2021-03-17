package View;

import java.awt.Font;

import javax.swing.JMenuItem;
import javax.swing.JPanel;

import View.Commands.NotableCommand;
import View.Listeners.AddNotableListener;
import Document.Method;
import Document.ObjectClass;

/**
 * Draws a method
 * @author Daniel Tyebkhan
 */
public class MethodDrawer extends NotableDrawer {
    private static final String ADD_PARAMETER = "Add Parameter";
    private static final String PARAM_NAME = "Enter Parameter Name";
    /**
     * Constructs an object to draw a class name
     */
    public MethodDrawer(Method method, ObjectClass object, JPanel parent, int width, int height, DiagramPanel diagramPanel) {
        super(method, new NotableCommand<Method>(method, object::removeMethod, object::addMethod), parent, width, height, diagramPanel);
        
        JMenuItem newParameter = new JMenuItem(ADD_PARAMETER);
        newParameter.addActionListener(new AddNotableListener(PARAM_NAME, method::addParameter, method::removeParameter, diagramPanel, diagramPanel));
        menu.add(newParameter);
    }
}
