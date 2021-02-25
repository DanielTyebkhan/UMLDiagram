package View.Listeners;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.List;
import java.util.ArrayList;

import Document.ObjectClass;
import Document.Storage;
import Document.Notable;
import Document.Arrow;
import Document.ArrowType;

/**
* Defines action listener for JRadio Buttons that decide what the arrow
* are being drawn between.
* @author Anhad Gande
*/
public class ArrowBetweenActionListener implements ActionListener {

	JRadioButton betweenMethodsOrVar;
	JRadioButton betweenNames;

	JComboBox to;
	JComboBox toNonObjects;

	/**
     * Constructs the listener
     */
	public ArrowBetweenActionListener(JRadioButton betweenMethodsOrVar, JRadioButton betweenNames, JComboBox to, JComboBox toNonObjects) {
		this.betweenMethodsOrVar = betweenMethodsOrVar;
		this.betweenNames = betweenNames;
		this.to = to;
		this.toNonObjects = toNonObjects;
	}
	/**
	* Updates the combo boxes based on what type of entities the arrow should be drawn.
	*/
	public void actionPerformed(ActionEvent a) {
		if (betweenMethodsOrVar.isSelected()) {
			toNonObjects.removeAllItems();
			ObjectClass item = (ObjectClass) to.getSelectedItem();
			List<Notable> methodsAndVars = item.getMethods();
			methodsAndVars.addAll(item.getInstanceVariables());
			for (Notable entry: methodsAndVars) {
				toNonObjects.addItem(entry);
			}
		}
		else if (betweenNames.isSelected()) {
			toNonObjects.removeAllItems();
		}
	}
}