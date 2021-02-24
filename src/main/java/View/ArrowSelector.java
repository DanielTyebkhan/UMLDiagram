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

	public ArrowSelector(){
		frame = new JFrame("Arrow Selector");
		JPanel panel = new JPanel();

		List<ObjectClass> objects = Storage.instance.getObjects();
		String[] objArray = new String[objects.size()];
		for (int i = 0; i < objects.size(); i++) {
			objArray[i] = objects.get(i).getName();
		}

		JButton selectFrom = new JButton("select From");
		from = new JComboBox(objArray);
		JButton selectTo = new JButton("select To");
		to = new JComboBox(objArray);

		selectFrom.addActionListener(this);
		selectTo.addActionListener(this);
		from.addItemListener(this);
		to.addItemListener(this);

		

		panel.add(from);
		panel.add(selectFrom);
		panel.add(to);
		panel.add(selectTo);
		

		frame.add(panel);
		frame.setLayout(new FlowLayout());
		frame.setSize(400, 300);
		frame.setVisible(true);
	}
	public void itemStateChanged(ItemEvent e) {

	}
	public void actionPerformed(ActionEvent e) {
		JComboBox cb = (JComboBox)e.getSource();
		String item = (String) cb.getSelectedItem();

	}
	public static void main(String[] args) {
		new ArrowSelector();
	}
}