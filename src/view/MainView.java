package view;

import java.awt.Container;
import javax.swing.BoxLayout;
import javax.swing.JFrame;

import controller.Controller;

public class MainView extends JFrame {
	private Controller controller;
	private MenuBar menu;
	private ButtonRow buttons;
	private SelectFileList pickers;
	private ConfigurationView configuration;
		
	public MainView(Controller controller) {
		this.setController(controller);
		this.setTitle(this.getController().getName());
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setJMenuBar(new MenuBar(this.getController()));
		this.setButtons(new ButtonRow(this.getController()));
		this.setPickers(new SelectFileList(this.getController()));
		this.setConfiguration(new ConfigurationView(this.getController()));
		Container content = this.getContentPane();
		content.add(this.getPickers());
		content.add(this.getConfiguration());
		content.add(this.getButtons());
		this.setLayout(new BoxLayout(content, BoxLayout.PAGE_AXIS));
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

	public ButtonRow getButtons() {
		return buttons;
	}

	public void setButtons(ButtonRow buttons) {
		this.buttons = buttons;
	}

	public SelectFileList getPickers() {
		return pickers;
	}

	public void setPickers(SelectFileList pickers) {
		this.pickers = pickers;
	}

	public ConfigurationView getConfiguration() {
		return configuration;
	}

	public void setConfiguration(ConfigurationView configuration) {
		this.configuration = configuration;
	}
}
