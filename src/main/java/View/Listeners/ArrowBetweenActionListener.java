package View.Listeners;

import javax.swing.*;
import java.awt.event.*;
import java.util.List;

import Document.ObjectClass;
import View.DiagramMember;
import View.DiagramPanel;
import Document.Notable;

/**
* Defines action listener for JRadio Buttons that decide what the arrow
* are being drawn between.
* @author Anhad Gande
*/
public class ArrowBetweenActionListener extends DiagramMember implements ActionListener {

	JRadioButton betweenMethodsOrVar;
	JRadioButton betweenNames;

	JComboBox<Notable> to;
	JComboBox<Notable> toNonObjects;

	/**
	 * Constructor 
	 * @param betweenMethodsOrVar 
	 * @param betweenNames 
	 * @param to
	 * @param toNonObjects
	 * @param diagramPanel
	 */
	public ArrowBetweenActionListener(JRadioButton betweenMethodsOrVar, JRadioButton betweenNames, JComboBox<Notable> to, JComboBox<Notable> toNonObjects, DiagramPanel diagramPanel) {
		super(diagramPanel);
		this.betweenMethodsOrVar = betweenMethodsOrVar;
		this.betweenNames = betweenNames;
		this.to = to;
		this.toNonObjects = toNonObjects;
	}
	/**
	 * Updates the combo boxes based on what type of entities the arrow should be drawn.
	 * @param a the trigger
	 */
	public void actionPerformed(ActionEvent a) {
		if (betweenMethodsOrVar.isSelected()) {
			toNonObjects.removeAllItems();
			ObjectClass item = (ObjectClass) to.getSelectedItem();
			List<Notable> methodsAndVars = item.getInstanceVariables();
			methodsAndVars.addAll(item.getMethods());
			for (Notable entry: methodsAndVars) {
				toNonObjects.addItem(entry);
			}
		}
		else if (betweenNames.isSelected()) {
			toNonObjects.removeAllItems();
		}
	}
}