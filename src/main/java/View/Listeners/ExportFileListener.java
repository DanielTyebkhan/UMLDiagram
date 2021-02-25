package View.Listeners;

import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;

import Filemanagement.Filechoose;

import View.DiagramPanel;

/**
 * @author Sai Lyon Ho
 */
public class ExportFileListener implements MouseListener {
    private DiagramPanel panel;
    private Filechoose fchoose = new Filechoose();

    public ExportFileListener(DiagramPanel panel){
        this.panel = panel;
    }

    public void mouseClicked(MouseEvent e) 
    {
        if (e.getButton() == MouseEvent.BUTTON1){
            fchoose.ExportImg(panel);
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

