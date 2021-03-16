package View.Listeners;

import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import Filemanagement.Filechoose;
import View.DiagramMember;
import View.DiagramPanel;
import View.WindowClass;


/**
 * Opens a file when the button is clicked
 * @author Sai Lyon Ho
 */
public class OpenFileListener implements MouseListener {
	WindowClass window; 

	public OpenFileListener(WindowClass window) {
		this.window = window;		
	}

	/**
	 * Handles Mouse event: clicked
	 * @param MouseEvent e
	 */
	public void mouseClicked(MouseEvent e) 
	{
		if (e.getButton() == MouseEvent.BUTTON1){
			new Filechoose(window.getCurrentDiagram()).LoadFile();
		}
	}

	/**
	 * Handles Mouse event: Entered
	 * @param MouseEvent e
	 */
	public void mouseEntered(MouseEvent e)
	{

	}

	/**
	 * Handles Mouse event: Exited
	 * @param MouseEvent e
	 */
	public void mouseExited(MouseEvent e) {

	}

	/**
	 * Handles Mouse event: Pressed
	 * @param MouseEvent e
	 */
	public void mousePressed(MouseEvent e) {
		
	}

	/**
	 * Handles Mouse event: Released
	 * @param MouseEvent e
	 */
	public void mouseReleased(MouseEvent e) {
	}
}

