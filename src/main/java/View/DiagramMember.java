package View;


public abstract class DiagramMember {
    private DiagramPanel panel;

    public DiagramMember(DiagramPanel panel) {
        this.panel = panel;
    }

    public DiagramPanel getDiagramPanel() {
        return panel;
    }
}
