package View.Theme;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import View.ThemeSelectorFrame;

/**
 * Listens for theme selector button  
 * @author Sai Lyon Ho
 */
public class ThemeSelectorListener implements ActionListener {

	/**
	 * actionPerformed
	 * @param ActionEvent e
	 */
	public void actionPerformed(ActionEvent e) {
		new ThemeSelectorFrame();
	}
}


