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

    public AddDiagramListener(WindowClass window) {
        this.window = window;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
		String name = JOptionPane.showInputDialog(e.getComponent(), "Enter Diagram Name");
		if (name != null && !name.equals(""))
            window.addDiagram(name, new DiagramPanel());
    }

    @Override
    public void mouseEntered(MouseEvent arg0) {
        
    }

    @Override
    public void mouseExited(MouseEvent arg0) {
        
    }

    @Override
    public void mousePressed(MouseEvent arg0) {
        
    }

    @Override
    public void mouseReleased(MouseEvent arg0) {
        
    }

    @Override
    public void mouseDragged(MouseEvent arg0) {
        
    }

    @Override
    public void mouseMoved(MouseEvent arg0) {
        
    }
    
}
