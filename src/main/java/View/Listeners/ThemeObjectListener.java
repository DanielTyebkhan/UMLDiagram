package View.Listeners;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import View.ThemeObject;



/**
 *  
 * @author Sai Lyon Ho
 */
public class ThemeObjectListener implements ActionListener {

	/**
	 * actionPerformed
	 * @param ActionEvent e
	 */
	public void actionPerformed(ActionEvent e) {
        System.out.println("Clicked Open Theme!");
		new ThemeObject();
	}
}


