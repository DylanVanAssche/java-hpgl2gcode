package view;

import java.awt.Container;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;

import controller.Controller;

public class MainView extends JFrame {
	private Controller controller;
	private MenuBar menu;
		
	public MainView(Controller controller) {
		this.setController(controller);
		this.setTitle(this.getController().getName());
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setJMenuBar(new MenuBar(this.getController()));
		Container content = this.getContentPane();
		this.setLayout(new BoxLayout(content, BoxLayout.PAGE_AXIS));
		this.add(new JButton("HELLO"));
		this.pack();
		this.setVisible(true);
	}

	public Controller getController() {
		return controller;
	}

	public void setController(Controller controller) {
		this.controller = controller;
	}

	public MenuBar getMenu() {
		return menu;
	}

	public void setMenu(MenuBar menu) {
		this.menu = menu;
	}
}
