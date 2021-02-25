package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.List;

import Document.ObjectClass;
import Document.Storage;

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

	JButton selectFrom;
	JButton selectTo;
	JButton makeArrow;

	JPanel panel;

	public ArrowSelector(){
		frame = new JFrame("Arrow Selector");
		panel = new JPanel();

		List<ObjectClass> objects = Storage.instance.getObjects();
		String[] objArray = new String[objects.size()];
		for (int i = 0; i < objects.size(); i++) {
			objArray[i] = objects.get(i).getName();
		}

		from = new JComboBox(objArray);
		fromNonObjects = new JComboBox();

		to = new JComboBox(objArray);
		toNonObjects = new JComboBox();

		selectFrom = new JButton("select From");
		selectTo = new JButton("select To");
		makeArrow = new JButton("Make Arrow");

		selectFrom.addActionListener(new selectFromButtonActionListener());

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

		JLabel type = new JLabel("Draw Arrows Between?");
		JLabel textFrom = new JLabel("From");
		JLabel textTo = new JLabel("To");
		JLabel arrowTypes = new JLabel("Arrow Types");


		subtype.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent a) {

			}
		});



		int selectFromIndex = 0;
		// selectFrom.addActionListener(new ActionListener()
		// 	{
		// 		public void actionPerformed(ActionEvent a) {
		// 			selectFromIndex = from.getSelectedIndex();
		// 		} 
		// 	});
		selectTo.addActionListener(this);


		from.addItemListener(this);
		to.addItemListener(this);

		panel.add(type);

		panel.add(betweenNames);
		panel.add(betweenMethodsOrVar);

		panel.add(textFrom);

		panel.add(from);
		panel.add(fromNonObjects);

		panel.add(selectFrom);

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
		JComboBox cb = (JComboBox)e.getSource();
		String item = (String) cb.getSelectedItem();

	}
	public void actionPerformed(ActionEvent e) {
		

	}
	public static void main(String[] args) {
		new ArrowSelector();
	}
	class selectFromButtonActionListener implements ActionListener {
		public void actionPerformed(ActionEvent a) {
			
		}

	}
}