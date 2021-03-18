package View.Listeners;

import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;

import Filemanagement.Filechoose;
import View.WindowClass;

/**
 * Listener Class for Export File button
 * @author Sai Lyon Ho
 */
public class ExportFileListener implements MouseListener {
    private WindowClass window;

    /**
     * Constructs the listener
     * @param panel the panel to listen on
     */
    public ExportFileListener(WindowClass window){
        this.window = window;
    }

    /**
     * Handles the click
     * @param e the trigger
     */
    public void mouseClicked(MouseEvent e) 
    {
        if (e.getButton() == MouseEvent.BUTTON1){
            new Filechoose(window.getCurrentDiagram()).ExportImg(window.getCurrentDiagram());
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

