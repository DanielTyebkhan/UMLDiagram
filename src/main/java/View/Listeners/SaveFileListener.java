package View.Listeners;

import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;

import Filemanagement.Filechoose;
import View.DiagramPanel;

/**
 * Saves the diagram to a file when the button is clicked
 * @author Sai Lyon Ho 
 */
public class SaveFileListener extends Listener implements MouseListener {
    public SaveFileListener(DiagramPanel panel) {
        super(panel);
    }

    private Filechoose fchoose = new Filechoose();

    public void mouseClicked(MouseEvent e) 
    {
        if (e.getButton() == MouseEvent.BUTTON1){
            fchoose.SaveFile();
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

