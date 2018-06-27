package view;

import java.awt.Container;
import java.util.ArrayList;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;

import controller.Controller;

public class MainView extends JFrame {
	private Controller controller;
	private MenuBar menu;
	private ButtonRow buttons;
	private ArrayList<SelectFile> pickers = new ArrayList<SelectFile>();
	private static final int NUMBER_OF_DRILLINGFILES = 4;
		
	public MainView(Controller controller) {
		this.setController(controller);
		this.setTitle(this.getController().getName());
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setJMenuBar(new MenuBar(this.getController()));
		for(int i=0; i < NUMBER_OF_DRILLINGFILES + 2; i++) {
			this.getPickers().add(new SelectFile(this.getController()));
		}
		this.setButtons(new ButtonRow(this.getController(), this.getPickers()));
		Container content = this.getContentPane();
		for(int i=0; i < NUMBER_OF_DRILLINGFILES + 2; i++) {
			content.add(this.getPickers().get(i));
		}
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

	public ArrayList<SelectFile> getPickers() {
		return pickers;
	}

	public void setPickers(ArrayList<SelectFile> pickers) {
		this.pickers = pickers;
	}
}
