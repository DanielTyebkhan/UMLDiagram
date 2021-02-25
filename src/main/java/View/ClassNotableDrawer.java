package View;

import javax.swing.JMenuItem;

import View.Listeners.AddNotableHandler;
import View.Listeners.ClassMenuListener;

public class ClassNotableDrawer extends NotableDrawer {
    public ClassNotableDrawer(ClassObject object, JPanel parent, int width, int height) {
        super(object, Storage.instance::removeObject, parent, width, height);
        label.setFont(new Font(FONT_NAME, Font.BOLD, FONT_SIZE));
    }
}
