package view;

import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JPanel;

import controller.Controller;

public class SelectFileList extends JPanel {
	private Controller controller;
	private DefaultListModel<SelectFile> filePaths = new DefaultListModel<SelectFile>();
	private ArrayList<SelectFile> filePathsList = new ArrayList<SelectFile>(); 

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

	public ArrayList<SelectFile> getFilePathsList() {
		return filePathsList;
	}

	public void setFilePathsList(ArrayList<SelectFile> filePathsList) {
		this.filePathsList = filePathsList;
	}
	
	public void addFilePath(SelectFile path) {
		this.getFilePaths().addElement(path);
		this.add(path);
	}
}
