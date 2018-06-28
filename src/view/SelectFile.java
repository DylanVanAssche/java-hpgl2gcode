package view;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controller.Controller;

public class SelectFile extends JPanel {
	private static final int SPACING = 10;
	private static final int ENGRAVING = 0;
	private static final int DRILLING = 1;
	private static final int MILLING = 2;
	private static final String[] MODES = {"engraving", "drilling", "milling"};
	private static final String FONT = "Courier New";
	private Controller controller;
	private JLabel filePath;
	private JComboBox<String> fileType;
	private int mode;
	
	public SelectFile(Controller controller, String path) {
		this.setController(controller);
		GridLayout layout = new GridLayout(1, 0);
		layout.setHgap(SPACING);
		this.setLayout(layout);
		this.setFilePath(new JLabel(path));
		this.setFileType(new JComboBox<String>(MODES));
		this.getFileType().setFont(new Font(FONT, Font.PLAIN, 12));
		this.getFileType().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				switch(getFileType().getSelectedItem().toString()) {
				case "engraving":
					setMode(ENGRAVING);
					break;
				case "drilling":
					setMode(DRILLING);
					break;
				case "milling":
					setMode(MILLING);
					break;
				}
			}
		});
		this.add(this.getFilePath());
		this.add(this.getFileType());
	}

	public Controller getController() {
		return controller;
	}

	public void setController(Controller controller) {
		this.controller = controller;
	}

	public JLabel getFilePath() {
		return filePath;
	}

	public void setFilePath(JLabel filePath) {
		this.filePath = filePath;
	}

	public JComboBox<String> getFileType() {
		return fileType;
	}

	public void setFileType(JComboBox<String> fileType) {
		this.fileType = fileType;
	}

	public String getAbsoluteFilePath() {
		return this.getFilePath().getText();
	}
	
	public int getMode() {
		return this.mode;
	}

	public void setMode(int mode) {
		this.mode = mode;
	}
}
