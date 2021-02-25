package View.Listeners;

import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Point;
import javax.swing.JOptionPane;

import Document.ObjectClass;
import Document.Storage;
import Filemanagement.Filechoose;

/**
 * @author Sai Lyon Ho 
 */
public class SaveFileListener implements MouseListener {
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

