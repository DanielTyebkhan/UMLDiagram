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

public class ArrowSelector extends JFrame implements ActionListener, ItemListener {

	private JFrame frame;
	private JComboBox from;
	private JComboBox fromNonObjects;
	private JComboBox to;
	private JComboBox toNonObjects;
	JRadioButton betweenNames;
	JRadioButton betweenMethodsOrVar;

	JRadioButton subtype;
	JRadioButton delegation;
	JRadioButton containment;

	JButton selectTo;
	JButton makeArrow;

	JPanel panel;

	public ArrowSelector() {
		frame = new JFrame("Arrow Selector");
		panel = new JPanel();

		List<ObjectClass> objects = Storage.instance.getObjects();
		ObjectClass[] objArray = new ObjectClass[objects.size()];
		for (int i = 0; i < objects.size(); i++) {
			objArray[i] = objects.get(i);
		}

		from = new JComboBox(objArray);
		fromNonObjects = new JComboBox();

		to = new JComboBox(objArray);
		toNonObjects = new JComboBox();

		selectTo = new JButton("Select To");
		makeArrow = new JButton("Make Arrow");

		selectTo.addActionListener(new SelectToListener());
		makeArrow.addActionListener(new ArrowTypeGroupActionListener());
		
		subtype = new JRadioButton("Subtype");
		delegation = new JRadioButton("Delegation");
		containment = new JRadioButton("containment");

		betweenNames = new JRadioButton("Between Classes");
		betweenMethodsOrVar = new JRadioButton("Between Methods or Variables");

		betweenNames.addActionListener(new methodsOrVarRadioButtonActionListener());
		betweenMethodsOrVar.addActionListener(new methodsOrVarRadioButtonActionListener());

		ButtonGroup groupArrowType = new ButtonGroup();
		groupArrowType.add(subtype);
		groupArrowType.add(delegation);
		groupArrowType.add(containment);

		ButtonGroup groupArrowBetween = new ButtonGroup();
		groupArrowBetween.add(betweenNames);
		groupArrowBetween.add(betweenMethodsOrVar);

		JLabel type = new JLabel("Draw Arrows Between?");
		JLabel textFrom = new JLabel("From");
		JLabel textTo = new JLabel("To");
		JLabel arrowTypes = new JLabel("Arrow Types");

		// selectFrom.addActionListener(new ActionListener()
		// 	{
		// 		public void actionPerformed(ActionEvent a) {
		// 			selectFromIndex = from.getSelectedIndex();
		// 		} 
		// 	});


		from.addItemListener(this);
		to.addItemListener(this);


		panel.add(textFrom);

		panel.add(from);
		panel.add(fromNonObjects);

		panel.add(type);

		panel.add(betweenNames);
		panel.add(betweenMethodsOrVar);

		panel.add(textTo);

		panel.add(to);
		panel.add(toNonObjects);

		panel.add(selectTo);


		panel.add(arrowTypes);

		panel.add(subtype);
		panel.add(delegation);
		panel.add(containment);

		panel.add(makeArrow);

		panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));

		frame.add(panel);
		frame.setSize(400, 500);
		frame.setVisible(true);
	}
	public void itemStateChanged(ItemEvent e) {

	}
	public void actionPerformed(ActionEvent e) {
		

	}
	public static void main(String[] args) {
		new ArrowSelector();
	}
	class selectFromButtonActionListener implements ActionListener {
		public void actionPerformed(ActionEvent a) {
			if (betweenMethodsOrVar.isSelected()) {
				ObjectClass item = (ObjectClass) from.getSelectedItem();
				List<Notable> methodsAndVars = item.getMethods();
				methodsAndVars.addAll(item.getInstanceVariables());
				for (Notable entry: methodsAndVars) {
					fromNonObjects.addItem(entry.getName());
				}
			}
		}

	}
	class methodsOrVarRadioButtonActionListener implements ActionListener {
		public void actionPerformed(ActionEvent a) {
			if (betweenMethodsOrVar.isSelected()) {
					ObjectClass item = (ObjectClass) from.getSelectedItem();
					List<Notable> methodsAndVars = item.getMethods();
					methodsAndVars.addAll(item.getInstanceVariables());
					for (Notable entry: methodsAndVars) {
						fromNonObjects.addItem(entry.getName());
					}
				}
			else if (betweenNames.isSelected()) {
				fromNonObjects.removeAllItems();
			}
		}
	}
	class SelectToListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if (betweenMethodsOrVar.isSelected()) {
				ObjectClass item = (ObjectClass) to.getSelectedItem();
				List<Notable> methodsAndVars = item.getMethods();
				methodsAndVars.addAll(item.getInstanceVariables());
				for (Notable entry: methodsAndVars) {
					toNonObjects.addItem(entry.getName());
				}
			}
			else if (betweenNames.isSelected()) {
				toNonObjects.removeAllItems();
			}
		}
	}
	class ArrowTypeGroupActionListener implements ActionListener {
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
			Notable fromClass = (Notable) from.getSelectedItem();
			Notable toClass = (Notable) to.getSelectedItem();
			Storage.instance.addArrow(new Arrow(typeArrow, fromClass, toClass));
			System.out.println("A");

		}
	}
}