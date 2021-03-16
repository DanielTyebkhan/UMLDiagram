package View.Arrows;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Document.Notable;
import View.DiagramPanel;

public class ArrowDialog extends JDialog implements PropertyChangeListener {
    private JPanel diagramPanel;
    private Notable notable;

    public ArrowDialog(Notable notable, DiagramPanel diagramPanel) {
        this.diagramPanel = diagramPanel;
        this.notable = notable;
    }

    public void show() {
        setTitle("Add Arrow");
        // content.removeAll();
        // content.add
    }

    @Override
    public void propertyChange(PropertyChangeEvent arg0) {
        // TODO Auto-generated method stub
        
    }
}
