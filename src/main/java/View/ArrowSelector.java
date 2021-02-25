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
	private boolean betweenNames = false;

	public ArrowSelector(){
		frame = new JFrame("Arrow Selector");
		JPanel panel = new JPanel();

		List<ObjectClass> objects = Storage.instance.getObjects();
		String[] objArray = new String[objects.size()];
		for (int i = 0; i < objects.size(); i++) {
			objArray[i] = objects.get(i).getName();
		}

		from = new JComboBox(objArray);
		to = new JComboBox(objArray);

		JButton selectFrom = new JButton("select From");
		JButton selectTo = new JButton("select To");

		JRadioButton subtype = new JRadioButton("Subtype", true);
		JRadioButton delegation = new JRadioButton("Subtype", false);
		JRadioButton containment = new JRadioButton("containment", false);



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

		panel.add(from);
		panel.add(selectFrom);
		panel.add(to);
		panel.add(subtype);
		panel.add(selectTo);
		panel.add(delegation);
		panel.add(containment);

		frame.add(panel);
		frame.setLayout(new GridLayout(3,3));
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
}