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
	private JTabbedPane tabPane;

	/**
	 * Constructs frame of WindowClass where MenuPanel and 
	 * DiagramPanel are instantiated   
	 */
	public WindowClass() {
		JFrame frame = new JFrame("Build Your Diagram!");

		tabPane = new JTabbedPane();
		tabPane.addTab("Diagram1", new DiagramPanel());
		
		new MenuPanel(frame, this);

		frame.add(BorderLayout.CENTER, tabPane);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(SIZE, SIZE);
		frame.setVisible(true); 
		// SwingUtilities.updateComponentTreeUI(frame);
	}


	/**
	 * Main method (for running program!)
	 * @param String[] args
	 */
	public static void main(String[] args){
		new WindowClass();
	}  

	public DiagramPanel getCurrentDiagram() {
		return (DiagramPanel)tabPane.getSelectedComponent();
	}

	public void addDiagram(String name, DiagramPanel dPanel) {
		tabPane.addTab(name, dPanel);
		tabPane.setSelectedIndex(tabPane.getTabCount() - 1);
	}
}
