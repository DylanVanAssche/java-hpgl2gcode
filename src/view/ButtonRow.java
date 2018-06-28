package view;

import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JPanel;

import controller.Controller;
import model.Configuration;

public class ButtonRow extends JPanel {
	private Controller controller;
	private JButton convertButton;
	private JButton addButton;
	private JFileChooser picker;
	private String pickedFilePath;
	
	public ButtonRow(Controller controller) {
		this.setController(controller);
		this.setLayout(new FlowLayout());
		this.setConvertButton(new JButton("Convert"));
		this.getConvertButton().setAlignmentX(Component.CENTER_ALIGNMENT);
		this.getConvertButton().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				getController().convert();				
			}
		});
		this.setAddButton(new JButton("Add file"));
		this.getAddButton().setAlignmentX(Component.CENTER_ALIGNMENT);
		this.getAddButton().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				showPicker();
			}
		});
		this.setPicker(new JFileChooser());
		this.getPicker().setCurrentDirectory(new File(System.getProperty("user.home")));
		this.add(this.getConvertButton());
		this.add(this.getAddButton());
	}

	public Controller getController() {
		return controller;
	}

	public void setController(Controller controller) {
		this.controller = controller;
	}

	public JButton getConvertButton() {
		return convertButton;
	}

	public void setConvertButton(JButton convertButton) {
		this.convertButton = convertButton;
	}

	public JButton getAddButton() {
		return addButton;
	}

	public void setAddButton(JButton addButton) {
		this.addButton = addButton;
	}
	
	public JFileChooser getPicker() {
		return picker;
	}

	public void setPicker(JFileChooser picker) {
		this.picker = picker;
	}

	public String getPickedFilePath() {
		return pickedFilePath;
	}

	public void setPickedFilePath(String pickedFilePath) {
		this.pickedFilePath = pickedFilePath;
	}

	private void showPicker() {
		int result = this.getPicker().showOpenDialog(this);
		if (result == JFileChooser.APPROVE_OPTION) {
		    File selectedFile = this.getPicker().getSelectedFile();
		    this.getController().addFilePath(selectedFile.getAbsolutePath());
		}
		else {
			System.err.println("File picking declined");
		}
	}
}
