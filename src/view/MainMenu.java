package view;

import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import controller.Controller;

public class MainMenu extends JMenuBar {
	private Controller controller;
	private JMenu aboutMenu;
	private JMenuItem aboutMenuMe;
	
	public MainMenu(Controller controller) {
		super();
		this.setController(controller);
		this.setAboutMenu(new JMenu("About"));
		this.setAboutMenuMe(new JMenuItem("Me"));
		
		this.getAboutMenu().add(this.getAboutMenuMe());
		this.add(this.getAboutMenu());
	}

	public Controller getController() {
		return controller;
	}

	public void setController(Controller controller) {
		this.controller = controller;
	}

	public JMenu getAboutMenu() {
		return aboutMenu;
	}

	public void setAboutMenu(JMenu aboutMenu) {
		this.aboutMenu = aboutMenu;
	}

	public JMenuItem getAboutMenuMe() {
		return aboutMenuMe;
	}

	public void setAboutMenuMe(JMenuItem jMenuItem) {
		this.aboutMenuMe = jMenuItem;
	}
}
