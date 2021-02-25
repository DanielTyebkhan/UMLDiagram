package View;

import javax.swing.JMenuItem;
import javax.swing.JPanel;
import java.awt.Font;

import View.Listeners.AddNotableHandler;
import Document.ObjectClass;
import Document.Storage;

/**
 * @author Daniel Tyebkhan
 */
public class ClassNotableDrawer extends NotableDrawer {
    private static final String NEW_METHOD = "Add Method";
    private static final String NEW_VARIABLE = "Add Variable";
    private static final String NEW_STEREOTYPE = "Add Stereotype";
    private static final String ENT_METHOD_NAME = "Enter Method Name";
    private static final String ENT_VARIABLE_NAME = "Enter Variable Name";
    private static final String ENT_STEREOTYPE_NAME = "Enter Stereotype Name";

    public ClassNotableDrawer(ObjectClass object, JPanel parent, int width, int height) {
        super(object, Storage.instance::removeObject, parent, width, height);
        label.setFont(new Font(FONT_NAME, Font.BOLD, FONT_SIZE));
        
        JMenuItem newMethod = new JMenuItem(NEW_METHOD);
        JMenuItem newVariable = new JMenuItem(NEW_VARIABLE);
        JMenuItem newStereotype = new JMenuItem(NEW_STEREOTYPE);
        newMethod.addActionListener(new AddNotableHandler(ENT_METHOD_NAME, object::addMethod, parent));
        newVariable.addActionListener(new AddNotableHandler(ENT_VARIABLE_NAME, object::addInstanceVariable, parent));
        newStereotype.addActionListener(new AddNotableHandler(ENT_STEREOTYPE_NAME, object::addStereotype, parent));
        menu.add(newMethod);
        menu.add(newVariable);
        menu.add(newStereotype);
    }
}