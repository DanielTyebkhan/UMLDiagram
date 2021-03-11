package View;

import java.awt.event.*; 
import java.awt.*; 
import javax.swing.*;

import View.DiagramPanel;

/**
* WindowClass creates a frame containing the MenuPanel 
* in the top and the DiagramPanel in the center
*
* @author  Sai Lyon Ho
*/
public class WindowClass extends JPanel{
	private static final int SIZE = 500;

	/**
	 * Constructs frame of WindowClass where MenuPanel and 
	 * DiagramPanel are instantiated   
	 */
	public WindowClass() {
		JFrame frame = new JFrame("Build Your Diagram!");
		DiagramPanel diagramPanel = new DiagramPanel();
		// diagramPanel.repaint();

		new MenuPanel(frame, diagramPanel);

		frame.add(BorderLayout.CENTER, diagramPanel);
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
}
