package View.Listeners;

import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.awt.Point;
import javax.swing.JOptionPane;

import Document.ObjectClass;
import Document.Storage;

/**
 * @author 
 */
public class ExportFileListener implements MouseListener {
    private String type;
    public ExportFileListener(String item){
        type = item;
    }

    public void mouseClicked(MouseEvent e) 
    {
        if (e.getButton() == MouseEvent.BUTTON1 && type == "JPEG"){
            System.out.println("Clicked Export JPEG!");
        }
        else {
            System.out.println("Clicked Export PNG!");
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

