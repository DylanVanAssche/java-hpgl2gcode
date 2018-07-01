package view;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JPanel;

public class JBorderPanel extends JPanel {
	
	public JBorderPanel(String title) {
		this.setBorder(BorderFactory.createTitledBorder(title));
		this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
	}
	
}
