package View.Listeners;

import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Filemanagement.Filechoose;

import javax.swing.JFileChooser;

/**
 * @author Sai Lyon Ho
 */
public class OpenFileListener implements MouseListener {
    private Filechoose fchoose = new Filechoose();
    public void mouseClicked(MouseEvent e) 
    {
        if (e.getButton() == MouseEvent.BUTTON1) 
		fchoose.LoadFile();
        	System.out.println("Clicked Open!");
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

