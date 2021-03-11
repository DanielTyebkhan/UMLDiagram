package View.Listeners;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import General.Command;
import View.DiagramPanel;

/**
 * Removes a notable based on a given method 
 * @author Daniel Tyebkhan 
 */
public class RemoveHandler extends Listener implements ActionListener {
    private Command remover;

    public RemoveHandler(DiagramPanel panel, Command remover) {
        super(panel);
        this.remover = remover;
    }
    
    public void actionPerformed(ActionEvent e) {
        getPanel().getCommandHandler().executeCommand(remover);
    }
}
