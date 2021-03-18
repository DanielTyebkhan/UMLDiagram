package View.Listeners;

import java.awt.event.MouseEvent;

import javax.swing.JOptionPane;
import javax.swing.event.MouseInputListener;

import View.DiagramPanel;
import View.WindowClass;

/**
 * Adds a new diagram to window
 * @author Daniel Tyebkhan
 */
public class AddDiagramListener implements MouseInputListener {
    private WindowClass window;

    /**
     * Constructs the listener
     * @param window the window to add the diagram to
     */
    public AddDiagramListener(WindowClass window) {
        this.window = window;
    }

    /**
     * Adds a diagram with name when triggered
     * @param e the trigger
     */
    @Override
    public void mouseClicked(MouseEvent e) {
		String name = JOptionPane.showInputDialog(e.getComponent(), "Enter Diagram Name");
		if (name != null && !name.equals(""))
            window.addDiagram(name, new DiagramPanel());
    }

    /**
     * Handles mouse entering
     * @param arg0 the trigger
     */
    @Override
    public void mouseEntered(MouseEvent arg0) {
        
    }

    /**
     * Handles mouse exiting
     * @param arg0 the trigger
     */
    @Override
    public void mouseExited(MouseEvent arg0) {
        
    }

    /**
     * Handles mouse pressed
     * @param arg0 the trigger
     */
    @Override
    public void mousePressed(MouseEvent arg0) {
        
    }

    /**
     * Handles mouse released
     * @param arg0 the trigger
     */
    @Override
    public void mouseReleased(MouseEvent arg0) {
        
    }

    /**
     * Handles mouse dragged
     * @param arg0 the trigger
     */
    @Override
    public void mouseDragged(MouseEvent arg0) {
        
    }

    /**
     * Handles mouse moved
     * @param arg0 the trigger
     */
    @Override
    public void mouseMoved(MouseEvent arg0) {
        
    }
    
}
