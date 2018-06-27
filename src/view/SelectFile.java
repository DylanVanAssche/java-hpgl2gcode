package view;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import controller.Controller;

public class SelectFile extends JPanel {
	Controller controller;
	JFileChooser picker;
	JButton showPickerButton;
	JTextField pickedFileName;
	
	public SelectFile(Controller controller) {
		GridLayout layout = new GridLayout(0, 2);
		this.setLayout(layout);
		this.setPicker(new JFileChooser());
		this.getPicker().setCurrentDirectory(new File(System.getProperty("user.home")));
		this.setShowPickerButton(new JButton("Pick"));
		this.getShowPickerButton().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				showPicker();
			}
		});
		this.setPickedFileName(new JTextField(""));
		this.getPickedFileName().setEditable(false);
		this.add(this.getPickedFileName());
		this.add(this.getShowPickerButton());
	}

	public Controller getController() {
		return controller;
	}

	public void setController(Controller controller) {
		this.controller = controller;
	}

	public JFileChooser getPicker() {
		return picker;
	}

	public void setPicker(JFileChooser picker) {
		this.picker = picker;
	}
	
	public JButton getShowPickerButton() {
		return showPickerButton;
	}

	public void setShowPickerButton(JButton showPickerButton) {
		this.showPickerButton = showPickerButton;
	}

	public JTextField getPickedFileName() {
		return pickedFileName;
	}

	public void setPickedFileName(JTextField pickedFileName) {
		this.pickedFileName = pickedFileName;
	}

	public void showPicker() {
		int result = this.getPicker().showOpenDialog(this);
		if (result == JFileChooser.APPROVE_OPTION) {
		    File selectedFile = this.getPicker().getSelectedFile();
		    this.getPickedFileName().setText(selectedFile.getAbsolutePath());
		}
		else {
			System.err.println("File picking declined");
		}
	}
	
	public boolean isSelected() {
		return this.getPickedFileName().getText().length() > 0;
	}
}
