package View.Listeners;

import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;

import Filemanagement.Filechoose;
import View.DiagramMember;
import View.DiagramPanel;

/**
 * Listener Class for Export File button
 * @author Sai Lyon Ho
 */
public class ExportFileListener extends DiagramMember implements MouseListener {
    private Filechoose fchoose;

    /**
     * Constructs the listener
     * @param panel the panel to listen on
     */
    public ExportFileListener(DiagramPanel panel){
        super(panel);
        fchoose = new Filechoose(panel);
    }

    /**
     * Handles the click
     * @param e the trigger
     */
    public void mouseClicked(MouseEvent e) 
    {
        if (e.getButton() == MouseEvent.BUTTON1){
            fchoose.ExportImg(getDiagramPanel());
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

