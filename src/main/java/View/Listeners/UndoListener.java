package View.Listeners;

import java.awt.event.ActionListener;

import javax.sound.sampled.SourceDataLine;

import View.DiagramPanel;

import java.awt.event.ActionEvent;

public class UndoListener extends Listener implements ActionListener {

    public UndoListener(DiagramPanel panel) {
        super(panel);
        System.out.println("Made undo listener");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("undoing");
        getPanel().getCommandHandler().undo();
        System.out.println("undone");
    }
    
}