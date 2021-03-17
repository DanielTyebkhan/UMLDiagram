package View.Theme;

import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import View.ThemeSelectorFrame;

/**
 * Saves the diagram to a file when the button is clicked
 * @author Sai Lyon Ho 
 */
public class ThemeSelectorMouseListener implements MouseListener {

    /**
     * Opens theme selector
     * @param e the trigger
     */
    public void mouseClicked(MouseEvent e) 
    {
        if (e.getButton() == MouseEvent.BUTTON1){
        	System.out.println("Clicked Open Theme in Menu!");
            new ThemeSelectorFrame();
        }
    }
    /**
     * Handles mouse entrance
     * @param e the trigger
     */
    public void mouseEntered(MouseEvent e)
    {

    }

    /**
     * Handles mouse exit
     * @param e the trigger
     */
    public void mouseExited(MouseEvent e) {

    }

    /**
     * Handles mouse press
     * @param e the trigger
     */
    public void mousePressed(MouseEvent e) {
        
    }

    /**
     * Handles mouse release
     * @param e the trigger
     */
    public void mouseReleased(MouseEvent e) {
    }
}

