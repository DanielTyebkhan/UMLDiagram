package View;

import java.awt.*;
import java.util.ArrayList;

import javax.swing.*;

/**
* WindowClass creates a frame containing the MenuPanel 
* in the top and the DiagramPanel in the center
*
* @author  Sai Lyon Ho
*/
public class WindowClass extends JPanel{
	private static final int SIZE = 500;
	private ArrayList<Tab> tabs;
	private Tab currentTab;

	/**
	 * Constructs frame of WindowClass where MenuPanel and 
	 * DiagramPanel are instantiated   
	 */
	public WindowClass() {
		tabs = new ArrayList<Tab>();
		addTab(new Tab("Diagram1", new DiagramPanel()));
		currentTab = tabs.get(0);

		JFrame frame = new JFrame("Build Your Diagram!");
		JPanel contentPanel = new JPanel(new BorderLayout());
		contentPanel.add(getCurrentDiagram(), BorderLayout.CENTER);
		// diagramPanel.repaint();

		
		new MenuPanel(frame, getCurrentDiagram());

		frame.add(BorderLayout.CENTER, contentPanel);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(SIZE, SIZE);
		frame.setVisible(true); 
		// SwingUtilities.updateComponentTreeUI(frame);
	}


	public void addTab(Tab tab) {
		tabs.add(tab);
	}

	/**
	 * Main method (for running program!)
	 * @param String[] args
	 */
	public static void main(String[] args){
		new WindowClass();
	}  

	public DiagramPanel getCurrentDiagram() {
		return currentTab.getDiagramPanel();
	}

	public void setCurrentTab(Tab tab) {
		currentTab = tab;
	}
}
