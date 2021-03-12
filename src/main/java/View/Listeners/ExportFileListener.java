package View.Listeners;

import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;

import Filemanagement.Filechoose;

import View.DiagramPanel;

/**
 * Listener Class for Export File button
 * @author Sai Lyon Ho
 */
public class ExportFileListener extends Listener implements MouseListener {
    private Filechoose fchoose = new Filechoose();

    /**
     * Constructs the listener
     * @param panel the panel to listen on
     */
    public ExportFileListener(DiagramPanel panel){
        super(panel);
    }

    /**
     * Handles the click
     * @param e the trigger
     */
    public void mouseClicked(MouseEvent e) 
    {
        if (e.getButton() == MouseEvent.BUTTON1){
            fchoose.ExportImg(getPanel());
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

