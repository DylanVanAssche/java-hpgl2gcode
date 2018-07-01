package view;

import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JCheckBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class JComponentLabel extends JPanel {
	private static final int SPACING = 10;
	private static final String FONT = "Courier New";
	private JComponent component;
	private JLabel label;
	
	public JComponentLabel(String label, JComponent component) {
		GridLayout layout = new GridLayout(0,2);
		layout.setHgap(SPACING);
		this.setLayout(layout);
		this.setJComponent(component);
		this.setLabel(new JLabel(label));
		this.getLabel().setFont(new Font(FONT, Font.PLAIN, 12));
		this.add(this.getLabel());
		this.add(this.getJComponent());
	}

	public JComponent getJComponent() {
		return component;
	}

	public void setJComponent(JComponent component) {
		this.component = component;
	}

	public JLabel getLabel() {
		return label;
	}

	public void setLabel(JLabel label) {
		this.label = label;
	}
	
	public String getValue() {
		if(this.getJComponent() instanceof JTextField) {
			JTextField textField = (JTextField)this.getJComponent();
			return textField.getText();
		}
		else if(this.getJComponent() instanceof JCheckBox) {
			JCheckBox checkBox = (JCheckBox)this.getJComponent();
			if(checkBox.isSelected()) {
				return "true";
			}
			else {
				return "false";
			}
		}
		else {
			return null;
		}
	}
}
