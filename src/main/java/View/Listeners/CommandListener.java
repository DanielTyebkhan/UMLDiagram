package View.Listeners;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import General.Command;
import View.DiagramMember;
import View.DiagramPanel;

/**
 * Listener to execute a command
 * @author Daniel Tyebkhan 
 */
public class CommandListener extends DiagramMember implements ActionListener {
    private Command remover;

    public CommandListener(DiagramPanel panel, Command remover) {
        super(panel);
        this.remover = remover;
    }
    
    public void actionPerformed(ActionEvent e) {
        getDiagramPanel().getCommandHandler().executeCommand(remover);
    }
}
