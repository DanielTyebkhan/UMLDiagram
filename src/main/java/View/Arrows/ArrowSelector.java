package View.Arrows;

import javax.swing.*;
import java.util.List;

import Document.ObjectClass;
import Document.Notable;
import View.DiagramPanel;
import View.Listeners.ArrowBetweenActionListener;
import View.Listeners.MakeArrowActionListener;

/**
* Displays a pop box where the user can decide to choose to draw arrows.
* @author Anhad Gande
*/
public class ArrowSelector extends JFrame { 
	private final static String FRAME_NAME = "Arrow Selector";
	private final static String MAKE_ARROW = "Make Arrow";
	private final static String SUBTYPE_ARROW = "Subtype";
	private final static String DELEGTION_ARROW = "Delegation";
	private final static String CONTAINMENT_ARROW = "containment";
	private final static String BETWEEN_CLASSES = "Between Class";
	private final static String BETWEEN_METHODS_OR_VARS = "Between Methods or Variables";
	private final static String DRAW_ARROWS_BETWEEN = "Draw Arrows Between?";
	private final static String TEXT_FROM = "From?";
	private final static String TEXT_TO = "To?";
	private final static String ARROW_TYPES = "Arrow Types";

	private JComboBox<Notable> to;
	private JComboBox<Notable> toNonObjects;
	private JRadioButton betweenNames;
	private JRadioButton betweenMethodsOrVar;

	private JTextField source;

	private JRadioButton subtype;
	private JRadioButton delegation;
	private JRadioButton containment;

	private JButton makeArrow;

	private JPanel panel;

	/**
	* Creates the frame and displays it
	*/
	public ArrowSelector(Notable notableFrom, DiagramPanel diagramPanel) {
		super(FRAME_NAME);
		
		panel = new JPanel();

		List<ObjectClass> objects = diagramPanel.getStorage().getObjects();
		ObjectClass[] objArray = new ObjectClass[objects.size()];
		for (int i = 0; i < objects.size(); i++) {
			objArray[i] = objects.get(i);
		}

		source = new JTextField(notableFrom.getName());
		source.setEditable(false);


		to = new JComboBox<Notable>(objArray);
		toNonObjects = new JComboBox<Notable>();

		makeArrow = new JButton(MAKE_ARROW);

		subtype = new JRadioButton(SUBTYPE_ARROW);
		delegation = new JRadioButton(DELEGTION_ARROW);
		containment = new JRadioButton(CONTAINMENT_ARROW);

		betweenNames = new JRadioButton(BETWEEN_CLASSES);
		betweenMethodsOrVar = new JRadioButton(BETWEEN_METHODS_OR_VARS);

		ButtonGroup groupArrowType = new ButtonGroup();
		groupArrowType.add(subtype);
		groupArrowType.add(delegation);
		groupArrowType.add(containment);

		ButtonGroup groupArrowBetween = new ButtonGroup();
		groupArrowBetween.add(betweenNames);
		groupArrowBetween.add(betweenMethodsOrVar);

		betweenNames.addActionListener(new ArrowBetweenActionListener(betweenMethodsOrVar, betweenNames, to, toNonObjects, diagramPanel));
		betweenMethodsOrVar.addActionListener(new ArrowBetweenActionListener(betweenMethodsOrVar, betweenNames, to, toNonObjects, diagramPanel));

		makeArrow.addActionListener(new MakeArrowActionListener(diagramPanel, notableFrom, subtype, delegation, containment, betweenMethodsOrVar, to, toNonObjects));

		JLabel type = new JLabel(DRAW_ARROWS_BETWEEN);
		JLabel textFrom = new JLabel(TEXT_FROM);
		JLabel textTo = new JLabel(TEXT_TO);
		JLabel arrowTypes = new JLabel(ARROW_TYPES);

		panel.add(textFrom);

		panel.add(source);

		panel.add(type);

		panel.add(betweenNames);
		panel.add(betweenMethodsOrVar);

		panel.add(textTo);

		panel.add(to);
		panel.add(toNonObjects);

		panel.add(arrowTypes);

		panel.add(subtype);
		panel.add(delegation);
		panel.add(containment);

		panel.add(makeArrow);

		panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));

		this.add(panel);
		this.setSize(400, 500);
		this.setVisible(true);
		System.out.println("ArrowSelector");
	}
}