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
	private JComboBox to;
	JRadioButton betweenNames;
	JRadioButton betweenMethodsOrVar;

	JRadioButton subtype;
	JRadioButton delegation;
	JRadioButton containment;

	JButton selectFrom;
	JButton selectTo;

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
		to = new JComboBox(objArray);

		selectFrom = new JButton("select From");
		selectTo = new JButton("select To");

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

		panel.add(betweenNames);
		panel.add(type);
		panel.add(betweenMethodsOrVar);
		panel.add(from);
		panel.add(selectFrom);
		panel.add(to);
		panel.add(subtype);
		panel.add(selectTo);
		panel.add(delegation);
		panel.add(containment);

		panel.setLayout(new GridLayout(3,3));

		frame.add(panel);
		frame.setSize(400, 300);
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