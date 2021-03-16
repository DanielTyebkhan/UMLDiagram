package View.Listeners;

import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;

import Filemanagement.Filechoose;
import View.DiagramMember;
import View.DiagramPanel;
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
            System.out.println("Clicked Open!");
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

