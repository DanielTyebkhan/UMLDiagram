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
 * Defines action for the make arrow button
 * are being drawn between.
 * @author Anhad Gande
 */

public class MakeArrowActionListener implements ActionListener {
	private Notable notableFrom;
	
	private JRadioButton subtype;
	private JRadioButton delegation;
	private JRadioButton containment;

	private JRadioButton betweenMethodsOrVar;

	private JComboBox to;
	private JComboBox toNonObjects;

	/**
     * Constructs the listener
     */

	public MakeArrowActionListener(Notable notableFrom, JRadioButton subtype, JRadioButton delegation, JRadioButton containment, 
		JRadioButton betweenMethodsOrVar, JComboBox to, JComboBox toNonObjects) {
		this.notableFrom = notableFrom;
		this.subtype = subtype;
		this.delegation = delegation;
		this.containment = containment;

		this.betweenMethodsOrVar =betweenMethodsOrVar;

		this.to = to;
		this.toNonObjects = toNonObjects;
	}
	/**
	* Adds arrow to Storage when the button is selected.
	*/
	public void actionPerformed(ActionEvent a) {
		ArrowType typeArrow = null;
		if (subtype.isSelected()) {
			
			typeArrow = ArrowType.SUBTYPE;
		}
		else if (delegation.isSelected()) {
			typeArrow = ArrowType.DELEGATION;
		}
		else if (containment.isSelected()) {
			typeArrow = ArrowType.CONTAINMENT;

		}
		Notable toNotable = null;
		if (betweenMethodsOrVar.isSelected()) {
			toNotable = (Notable) toNonObjects.getSelectedItem();
		}
		else {
			toNotable = (Notable) to.getSelectedItem();
		}
		Storage.instance.addArrow(new Arrow(typeArrow, notableFrom, toNotable));
	}
}