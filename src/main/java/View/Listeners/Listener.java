package View.Listeners;

import View.DiagramPanel;

public abstract class Listener {
    private DiagramPanel parent;

    public Listener(DiagramPanel parent) {
        this.parent = parent;
    }

    public DiagramPanel getParent() {
        return parent;
    }
}
