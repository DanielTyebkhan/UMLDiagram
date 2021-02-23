package View.Listeners;

import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;

public class AddClassListener implements MouseListener {
    private static final String CLASS_NAME_PROMPT = "Enter Class Name";
    public void mouseClicked(MouseEvent e) {
       String name = JOptionPane.showInputDialog(this, CLASS_NAME_PROMPT);
       if (name != null || !name.equals(""))
           Storage.instance.addObject(new ObjectClass(name, new Point(e.getPoint())));
    }

    public void mouseEntered(MouseEvent e)
    {

    }
    public void mouseExited(MouseEvent e)
    {

    }
    public void mousePressed(MouseEvent e)
    {

    }
    public void mouseReleased(MouseEvent e)
    {

    }

}

