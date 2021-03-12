package View.Theme;

import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import View.ThemeSelectorFrame;

/**
 * Saves the diagram to a file when the button is clicked
 * @author Sai Lyon Ho 
 */
public class ThemeSelectorMouseListener implements MouseListener {

    public void mouseClicked(MouseEvent e) 
    {
        if (e.getButton() == MouseEvent.BUTTON1){
        	System.out.println("Clicked Open Theme in Menu!");
            new ThemeSelectorFrame();
        }
    }
    public void mouseEntered(MouseEvent e)
    {

    }

    public void mouseExited(MouseEvent e) {

    }

    public void mousePressed(MouseEvent e) {
        
    }

    public void mouseReleased(MouseEvent e) {
    }
}

