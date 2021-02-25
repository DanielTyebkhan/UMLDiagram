package View.Listeners;

import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import Filemanagement.Filechoose;

import javax.swing.JFileChooser;

/**
 * Opens a file when the button is clicked
 * @author Sai Lyon Ho
 */
public class OpenFileListener implements MouseListener {
	private Filechoose fchoose = new Filechoose();
	
	/**
	 * Handles Mouse event: clicked
	 * @param MouseEvent e
	 */
	public void mouseClicked(MouseEvent e) 
	{
		if (e.getButton() == MouseEvent.BUTTON1){
			fchoose.LoadFile();
			System.out.println("Clicked Open!");
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

