package view;

import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JPanel;

import controller.Controller;

public class SelectFileList extends JPanel {
	private Controller controller;
	private DefaultListModel<SelectFile> filePaths = new DefaultListModel<SelectFile>();

	public SelectFileList(Controller controller) {
		this.setController(controller);
		this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
	}
	
	public Controller getController() {
		return controller;
	}

	public void setController(Controller controller) {
		this.controller = controller;
	}

	public DefaultListModel<SelectFile> getFilePaths() {
		return filePaths;
	}
	
	public void setFilePaths(DefaultListModel<SelectFile> filePaths) {
		this.filePaths = filePaths;
	}
	
	private void updateView() {
		this.removeAll();
		for(int i=0; i<this.getFilePaths().size(); i++) {
			this.add(this.getFilePaths().get(i));
		}
		this.revalidate();
		this.repaint();
	}
	
	public void addFilePath(SelectFile path) {
		this.getFilePaths().addElement(path);
		this.updateView();
	}

	public void removeFile(SelectFile file) {
		this.getFilePaths().removeElement(file);
		this.updateView();
	}
}
