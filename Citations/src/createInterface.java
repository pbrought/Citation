import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.text.*;

public class createInterface extends JPanel implements ActionListener, FocusListener {
    JTextField authorField, titleField, sourceField, editorField, pubField;
    JLabel citationDisplay;
    final static int GAP = 10;
    static final long serialVersionUID = 1L;

	
	public createInterface(){
 	      setLayout(new BoxLayout(this, BoxLayout.LINE_AXIS));

		JPanel leftHalf = new JPanel() {
			public Dimension getMaximumSize() {
				Dimension pref = getPreferredSize();
				return new Dimension(Integer.MAX_VALUE, pref.height);
			}
		};
		leftHalf.setLayout(new BoxLayout(leftHalf, BoxLayout.PAGE_AXIS));
		leftHalf.add(createEntryFields());
		leftHalf.add(createButtons());

		add(leftHalf);
		add(createCitationDisplay());
	}
	
	private JComponent createEntryFields(){
		JPanel panel = new JPanel(new SpringLayout());
		
		String[] labelStrings = {
				"Enter author: ",
				"Enter title: ",
				"Enter source: ",
				"Enter editor: ",
				"Enter publishing date: "
		};
		JLabel[] labels = new JLabel[labelStrings.length];
		JComponent[] fields = new JComponent[labelStrings.length];
		int fieldNum = 0;
		
		authorField = new JTextField(20);
		fields[fieldNum++] = authorField;
		
		titleField = new JTextField(20);
		fields[fieldNum++] = titleField;
		
		sourceField = new JTextField(20);
		fields[fieldNum++] = sourceField;
		
		editorField = new JTextField(20);
		fields[fieldNum++] = editorField;
		
		pubField = new JTextField(20);
		fields[fieldNum++] = pubField;
		
		for(int i = 0; i<labelStrings.length; i++){
			labels[i] = new JLabel(labelStrings[i], JLabel.TRAILING);
			labels[i].setLabelFor(fields[i]);
			panel.add(labels[i]);
			panel.add(fields[i]);
			
			JTextField tf = null;
			if(fields[i] instanceof JSpinner){
				tf = getTextField((JSpinner)fields[i]);
			}
		}
		return panel;
	}
	
	public JTextField getTextField(JComponent j){
		return null;
	}
	
	public void focusLost(FocusEvent e) {} //not needed
	
	public void focusGained(FocusEvent e){} //do later
	
	private JComponent createButtons(){
		JPanel panel = new JPanel();
		return panel;
	}
	
	private JComponent createCitationDisplay(){
		JPanel panel = new JPanel();
		return panel;
	}
	
	public void actionPerformed(ActionEvent evt){

//		String text = textField.getText();
//		textArea.append(text + newline);
//		textField.selectAll();
//		
//		textArea.setCaretPosition(textArea.getDocument().getLength());
	}
	
	public static void createAndShowGUI(){
		JFrame frame = new JFrame("CitationSorter");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel emptyLabel = new JLabel("wutwutinthebutt");
		emptyLabel.setPreferredSize(new Dimension(1000, 1000));
		frame.getContentPane().add(emptyLabel, BorderLayout.CENTER);
		
		frame.add(new createInterface());
		
		
		frame.pack();
		frame.setVisible(true);
	}
	
}
