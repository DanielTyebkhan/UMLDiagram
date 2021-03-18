package View.Listeners;

import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;

import Filemanagement.Filechoose;
import View.WindowClass;

/**
 * Saves the diagram to a file when the button is clicked
 * @author Sai Lyon Ho 
 */
public class SaveFileListener implements MouseListener {
    private WindowClass window;

    /**
     * Constructs a file save listener
     * @param window the window to save the file from
     */
    public SaveFileListener(WindowClass window) {
        this.window = window;
    }


    /**
     * Handles mouse clicks
     * @param e the trigger
     */
    public void mouseClicked(MouseEvent e) 
    {
        if (e.getButton() == MouseEvent.BUTTON1){
            new Filechoose(window.getCurrentDiagram()).SaveFile();
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

