package View.Listeners;

import View.DiagramPanel;

public abstract class Listener {
    private DiagramPanel panel;

    public Listener(DiagramPanel panel) {
        this.panel = panel;
    }

    public DiagramPanel getPanel() {
        return panel;
    }
}
