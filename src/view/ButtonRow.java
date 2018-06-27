package view;

import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JPanel;

import controller.Controller;

public class ButtonRow extends JPanel {
	private Controller controller;
	private JButton convertButton;
	
	public ButtonRow(Controller controller, ArrayList<SelectFile> pickers) {
		this.setController(controller);
		this.setLayout(new FlowLayout());
		this.setConvertButton(new JButton("Convert"));
		this.getConvertButton().setAlignmentX(Component.CENTER_ALIGNMENT);
		this.getConvertButton().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				getController().convert(pickers);				
			}
		});
		this.add(this.getConvertButton());
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
}
