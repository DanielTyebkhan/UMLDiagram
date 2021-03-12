package View.Listeners;

import javax.swing.*;
import java.awt.event.*;

import Document.Storage;
import View.DiagramPanel;
import View.Commands.NotableCommand;
import Document.Notable;
import Document.Arrow;
import Document.ArrowType;

/**
 * Defines action for the make arrow button
 * are being drawn between.
 * @author Anhad Gande
 */

public class MakeArrowActionListener extends Listener implements ActionListener {
	private Notable notableFrom;
	
	private JRadioButton subtype;
	private JRadioButton delegation;
	private JRadioButton containment;

	private JRadioButton betweenMethodsOrVar;

	private JComboBox<Notable> to;
	private JComboBox<Notable> toNonObjects;

	/**
     * Constructs the listener
     */

	public MakeArrowActionListener(DiagramPanel diagramPanel, Notable notableFrom, JRadioButton subtype, JRadioButton delegation, JRadioButton containment, JRadioButton betweenMethodsOrVar, JComboBox<Notable> to, JComboBox<Notable> toNonObjects) {
		super(diagramPanel);
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
		getPanel().getCommandHandler().executeCommand(new NotableCommand<Arrow>(new Arrow(typeArrow, notableFrom, toNotable), Storage.instance::addArrow, Storage.instance::removeArrow));
	}
}