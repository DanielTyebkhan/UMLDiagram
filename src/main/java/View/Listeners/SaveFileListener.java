package View.Listeners;

import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;

import Filemanagement.Filechoose;
import View.DiagramMember;
import View.DiagramPanel;
import View.WindowClass;

/**
 * Saves the diagram to a file when the button is clicked
 * @author Sai Lyon Ho 
 */
public class SaveFileListener implements MouseListener {
    private WindowClass window;

    public SaveFileListener(WindowClass window) {
        this.window = window;
    }


    public void mouseClicked(MouseEvent e) 
    {
        if (e.getButton() == MouseEvent.BUTTON1){
            new Filechoose(window.getCurrentDiagram()).SaveFile();
        	System.out.println("Clicked Save!");
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

