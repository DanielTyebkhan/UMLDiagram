package View.Listeners;

import java.awt.event.ActionListener;

import View.WindowClass;

import java.awt.event.ActionEvent;

/**
 * Listener for undo
 */
public class UndoListener implements ActionListener {
    public WindowClass window;

    /**
     * Constructs the listener
     * @param window the window to undo from
     */
    public UndoListener(WindowClass window) {
        this.window = window;
    }

    /**
     * Undoes the last action on the focused diagram
     * @param e the trigger
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        window.getCurrentDiagram().getCommandHandler().undo();
    }
    
}