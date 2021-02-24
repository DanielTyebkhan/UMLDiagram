package View.Listeners;

import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.awt.Point;
import javax.swing.JOptionPane;

import Document.ObjectClass;
import Document.Storage;

import View.DiagramPanel;

/**
 * @author Sai Lyon Ho
 */
public class ExportFileListener implements ActionListener {
    private String type;
    private DiagramPanel panel;

    public ExportFileListener(String item, DiagramPanel panel){
        this.type = item;
        this.panel = panel;
    }

    public void actionPerformed(ActionEvent e)
    {
        if (type == "JPEG"){
            System.out.println("Clicked Export JPEG!");
        }
        else {
            System.out.println("Clicked Export PNG!");
        }
        System.out.println(panel);
        
    }
    // public void mouseClicked(MouseEvent e) 
    // {
    //     if (e.getButton() == MouseEvent.BUTTON1 && type == "JPEG"){
    //         System.out.println("Clicked Export JPEG!");
    //     }
    //     else {
    //         System.out.println("Clicked Export PNG!");
    //     }
        
    // }
    // public void mouseEntered(MouseEvent e)
    // {

    // }

    // public void mouseExited(MouseEvent e) {

    // }

    // public void mousePressed(MouseEvent e) {
        
    // }

    // public void mouseReleased(MouseEvent e) {
    // }

}

