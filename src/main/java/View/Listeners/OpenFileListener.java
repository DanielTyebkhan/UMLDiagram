package View.Listeners;

import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
// import java.awt.event.ActionEvent;
// import java.awt.event.ActionListener;

import javax.swing.JFileChooser;

/**
 * @author Sai Lyon Ho
 */
public class OpenFileListener implements MouseListener {

    // public void actionPerformed(ActionEvent e)
    // {
    //     System.out.println("Clicked Open File!");
    // }

    public void mouseClicked(MouseEvent e) 
    {
        if (e.getButton() == MouseEvent.BUTTON1) 
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

