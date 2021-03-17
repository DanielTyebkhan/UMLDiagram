package View;

import java.awt.Font;

import javax.swing.JMenuItem;
import javax.swing.JPanel;

import View.Commands.NotableCommand;
import View.Listeners.AddMethodListener;
import View.Listeners.AddNotableListener;
import View.Theme.ThemeSelectorListener;
import Document.Method;
import Document.ObjectClass;

/**
 * Draws a method
 * @author Daniel Tyebkhan
 */
public class MethodDrawer extends NotableDrawer {
    /**
     * Constructs an object to draw a class name
     */
    public MethodDrawer(Method method, ObjectClass object, JPanel parent, int width, int height, DiagramPanel diagramPanel) {
        super(method, new NotableCommand<Method>(method, object::removeMethod, object::addMethod), parent, width, height, diagramPanel);
        label.setFont(new Font(FONT_NAME, Font.BOLD, FONT_SIZE));
        
        JMenuItem newParameter = new JMenuItem(ADD_PARAMETER);

        newParameter.addActionListener(new AddParameterListener(method, parent, diagramPanel));

        menu.add(newParameter);
    }
}
