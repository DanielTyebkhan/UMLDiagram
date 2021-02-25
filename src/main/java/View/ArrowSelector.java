package View;

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
import View.Listeners.ArrowBetweenActionListener;
import View.Listeners.RefreshListener;
import View.Listeners.MakeArrowActionListener;

/**
* Displays a pop box where the user can decide to choose to draw arrows.
* @author Anhad Gande
*/

public class ArrowSelector extends JFrame {

	private JComboBox to;
	private JComboBox toNonObjects;
	private Notable notableFrom;
	private JRadioButton betweenNames;
	private JRadioButton betweenMethodsOrVar;

	private JTextField source;

	private JRadioButton subtype;
	private JRadioButton delegation;
	private JRadioButton containment;

	private JButton refresh;
	private JButton makeArrow;

	private JPanel panel;

	/**
	* Creates the frame and displays it
	*/
	public ArrowSelector(Notable notableFrom) {
		super("Arrow Selector");
		this.notableFrom = notableFrom;
		
		panel = new JPanel();

		List<ObjectClass> objects = Storage.instance.getObjects();
		ObjectClass[] objArray = new ObjectClass[objects.size()];
		for (int i = 0; i < objects.size(); i++) {
			objArray[i] = objects.get(i);
		}

		source = new JTextField(notableFrom.getName());
		source.setEditable(false);


		to = new JComboBox(objArray);
		toNonObjects = new JComboBox();

		refresh = new JButton("Refresh");
		makeArrow = new JButton("Make Arrow");

		subtype = new JRadioButton("Subtype");
		delegation = new JRadioButton("Delegation");
		containment = new JRadioButton("containment");

		betweenNames = new JRadioButton("Between Classes");
		betweenMethodsOrVar = new JRadioButton("Between Methods or Variables");

		ButtonGroup groupArrowType = new ButtonGroup();
		groupArrowType.add(subtype);
		groupArrowType.add(delegation);
		groupArrowType.add(containment);

		ButtonGroup groupArrowBetween = new ButtonGroup();
		groupArrowBetween.add(betweenNames);
		groupArrowBetween.add(betweenMethodsOrVar);

		betweenNames.addActionListener(new ArrowBetweenActionListener(betweenMethodsOrVar, betweenNames, to, toNonObjects));
		betweenMethodsOrVar.addActionListener(new ArrowBetweenActionListener(betweenMethodsOrVar, betweenNames, to, toNonObjects));

		refresh.addActionListener(new RefreshListener(betweenMethodsOrVar, betweenNames, to, toNonObjects));
		makeArrow.addActionListener(new MakeArrowActionListener(notableFrom, subtype, delegation, containment, betweenMethodsOrVar, to, toNonObjects));

		JLabel type = new JLabel("Draw Arrows Between?");
		JLabel textFrom = new JLabel("From");
		JLabel textTo = new JLabel("To");
		JLabel arrowTypes = new JLabel("Arrow Types");

		panel.add(textFrom);

		panel.add(source);

		panel.add(type);

		panel.add(betweenNames);
		panel.add(betweenMethodsOrVar);

		panel.add(textTo);

		panel.add(to);
		panel.add(toNonObjects);

		panel.add(refresh);


		panel.add(arrowTypes);

		panel.add(subtype);
		panel.add(delegation);
		panel.add(containment);

		panel.add(makeArrow);

		panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));

		this.add(panel);
		this.setSize(400, 500);
		this.setVisible(true);
	}
}