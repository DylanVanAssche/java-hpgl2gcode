package view;

import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import controller.Controller;

public class MenuBar extends JMenuBar {
	private Controller controller;
	private JMenu aboutMenu;
	private JMenuItem applicationAboutMenu;
	private JMenuItem githubAboutMenu;
	
	public MenuBar(Controller controller) {
		this.setController(controller);
		this.setAboutMenu(new JMenu("About"));
		this.add(this.getAboutMenu());
		this.setApplicationAboutMenu(new JMenuItem("Application"));
		this.getApplicationAboutMenu().setToolTipText("About " + this.getController().getName());
		this.getAboutMenu().add(this.getApplicationAboutMenu());
		this.setGithubAboutMenu(new JMenuItem("Github"));
		this.getGithubAboutMenu().setToolTipText("Github repository");
		this.getAboutMenu().add(this.getGithubAboutMenu());
		this.getApplicationAboutMenu().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				String dialogText = getController().getName() + "\nVersion: " + getController().getVersion() + "\nAuthor: " + getController().getAuthor();
				JOptionPane.showMessageDialog(null, dialogText, "About", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		this.getGithubAboutMenu().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				try {
					Desktop.getDesktop().browse(new URI("https://www.github.com/dylanvanassche/java-hpgl2gcode"));
				} 
				catch(IOException e) {
					JOptionPane.showMessageDialog(null, "URI handler not found!\nDid you install a webbrowser?", "Error", JOptionPane.ERROR_MESSAGE);
				}
				catch(URISyntaxException e) {
					JOptionPane.showMessageDialog(null, "URI isn't conform with the RFC 2396!", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
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

	public JMenuItem getApplicationAboutMenu() {
		return applicationAboutMenu;
	}

	public void setApplicationAboutMenu(JMenuItem applicationAboutMenu) {
		this.applicationAboutMenu = applicationAboutMenu;
	}

	public JMenuItem getGithubAboutMenu() {
		return githubAboutMenu;
	}

	public void setGithubAboutMenu(JMenuItem githubAboutMenu) {
		this.githubAboutMenu = githubAboutMenu;
	}
}
