package View.Commands;

import View.DiagramPanel;

public abstract class DiagramComponent {
    private DiagramPanel diagramPanel;

    public DiagramComponent(DiagramPanel diagramPanel) {
        this.diagramPanel = diagramPanel;
    }

    public DiagramPanel getDiagramPanel() {
        return diagramPanel;
    }
}
