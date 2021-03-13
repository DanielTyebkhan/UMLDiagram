package View;

public class Tab {
    private String name;
    private DiagramPanel diagramPanel;
    
    public Tab(String name, DiagramPanel diagramPanel) {
        setName(name);
        setDiagramPanel(diagramPanel);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDiagramPanel(DiagramPanel diagramPanel) {
        this.diagramPanel = diagramPanel;
    }

    public String getName() {
        return name;
    }

    public DiagramPanel getDiagramPanel() {
        return diagramPanel;
    }
}
