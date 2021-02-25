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

import View.DiagramPanel;

/**
 * @author Sai Lyon Ho
 */
public class ExportFileListener implements ActionListener {
    private DiagramPanel panel;
    private Filechoose fchoose = new Filechoose();

    public ExportFileListener(DiagramPanel panel){
        this.panel = panel;
    }

    public void actionPerformed(ActionEvent e)
    {
        fchoose.ExportImg(panel);
        
    }
}

