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

    /**
     * Constructs a command listener
     * @param panel the diagram associated with the command
     * @param remover the command to execute
     */
    public CommandListener(DiagramPanel panel, Command remover) {
        super(panel);
        this.remover = remover;
    }
    
    /**
     * performs the command
     */
    public void actionPerformed(ActionEvent e) {
        getDiagramPanel().getCommandHandler().executeCommand(remover);
    }
}
