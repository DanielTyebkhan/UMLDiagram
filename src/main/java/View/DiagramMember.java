package View;

/**
 * A class which is in a diagram
 * @author Daniel Tyebkhan
 */
public abstract class DiagramMember {
    private DiagramPanel panel;

    /**
     * Constructs a diagram member
     * @param panel the diagram it is a part of 
     */
    public DiagramMember(DiagramPanel panel) {
        this.panel = panel;
    }

    /**
     * Gets a reference to the diagram the member is in
     * @return the diagram
     */
    public DiagramPanel getDiagramPanel() {
        return panel;
    }
}
