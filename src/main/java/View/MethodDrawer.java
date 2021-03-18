package View;

import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JMenuItem;
import javax.swing.JPanel;

import View.Commands.NotableCommand;
import View.Listeners.AddNotableListener;
import Document.Method;
import Document.Notable;
import Document.ObjectClass;

/**
 * Draws a method
 * @author Daniel Tyebkhan
 */
public class MethodDrawer extends NotableDrawer {
    private static final String ADD_PARAMETER = "Add Parameter";
    private static final String PARAM_NAME = "Enter Parameter Name";
    private static final String LEFT_PAREN = "(";
    private static final String RIGHT_PAREN = ")";
    private static final String COMMA_SPACE = ", ";

    /**
     * Constructs an object to draw a class name
     */
    public MethodDrawer(Method method, ObjectClass object, JPanel parent, int width, int height, DiagramPanel diagramPanel) {
        super(method, new NotableCommand<Method>(method, object::removeMethod, object::addMethod), parent, width, height, diagramPanel);
        
        JMenuItem newParameter = new JMenuItem(ADD_PARAMETER);
        newParameter.addActionListener(new AddNotableListener(PARAM_NAME, method::addParameter, method::removeParameter, diagramPanel, diagramPanel));
        menu.add(newParameter);
    }

    /**
     * Formats the method to be drawn
     */
    @Override
    protected String getLabelText() {
        Method method = (Method) getNotable();
        ArrayList<Notable> parameters = method.getParameters();
        ArrayList<String> paramNames = new ArrayList<String>(parameters.size());
        for (Notable p : parameters) 
            paramNames.add(p.getName());
        return method.getName() + LEFT_PAREN + String.join(COMMA_SPACE, paramNames) + RIGHT_PAREN;
    }
}
