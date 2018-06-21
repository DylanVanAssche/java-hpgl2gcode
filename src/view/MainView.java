package view;

import java.awt.Container;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import controller.Controller;

public class MainView extends JFrame {
	Controller controller;
	MainMenu menu;
	
	public MainView(Controller controller) {
		this.setController(controller);
		this.setTitle("HPGL2Gcode");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new FlowLayout());
		this.setMenu(new MainMenu(this.getController()));
		Container contentPane = this.getContentPane();
		contentPane.add(new JButton("Hello World"));
		
		this.setJMenuBar(this.getMenu());
		this.pack();
		this.setVisible(true);
	}
	
	public Controller getController() {
		return controller;
	}

	public void setController(Controller controller) {
		this.controller = controller;
	}

	public MainMenu getMenu() {
		return menu;
	}

	public void setMenu(MainMenu menu) {
		this.menu = menu;
	}
}
