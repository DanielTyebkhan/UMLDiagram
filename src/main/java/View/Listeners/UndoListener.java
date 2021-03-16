package View.Listeners;

import java.awt.event.ActionListener;

import View.WindowClass;

import java.awt.event.ActionEvent;

public class UndoListener implements ActionListener {
    public WindowClass window;

    public UndoListener(WindowClass window) {
        this.window = window;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        window.getCurrentDiagram().getCommandHandler().undo();
    }
    
}