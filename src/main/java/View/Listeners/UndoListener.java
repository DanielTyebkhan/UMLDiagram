package View.Listeners;

import java.awt.event.ActionListener;

import View.DiagramMember;
import View.DiagramPanel;

import java.awt.event.ActionEvent;

public class UndoListener extends DiagramMember implements ActionListener {

    public UndoListener(DiagramPanel panel) {
        super(panel);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        getDiagramPanel().getCommandHandler().undo();
    }
    
}