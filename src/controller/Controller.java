/*
*   This file is part of java-hpgl2gcode.
*
*   java-hpgl2gcode is free software: you can redistribute it and/or modify
*   it under the terms of the GNU General Public License as published by
*   the Free Software Foundation, either version 3 of the License, or
*   (at your option) any later version.
*
*   java-hpgl2gcode is distributed in the hope that it will be useful,
*   but WITHOUT ANY WARRANTY; without even the implied warranty of
*   MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
*   GNU General Public License for more details.
*
*   You should have received a copy of the GNU General Public License
*   along with java-hpgl2gcode.  If not, see <http://www.gnu.org/licenses/>.
*/

package controller;

import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import model.Configuration;
import model.GCodeWriter;
import model.HPGLReader;
import model.Job;
import view.ConfigurationView;
import view.MainView;
import view.SelectFile;
import view.SelectFileList;

public class Controller {
	private static Controller controller;
	private MainView view;
	private String author = "Dylan Van Assche";
	private String version = "V1.0.0";
	private String name = "HPGL2Gcode";
	
	private Controller() {
		// Controller stuff
		// Configuration for each JOB: engraving, milling, drilling all different jobs!
		this.setView(new MainView(this));
	}
	
	// Singleton pattern, only 1 instance may exist! Use .newInstance() to retrieve a Controller instance
	public static Controller newInstance() {
		if(controller == null) {
			controller = new Controller();
		}
		return controller;
	}
	
	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public MainView getView() {
		return view;
	}

	public void setView(MainView view) {
		this.view = view;
	}

	// Launch the Controller on application start
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		Controller controller = Controller.newInstance();
	}

	public void convert() throws IOException, InterruptedException {
		Processor.convert(this);
	}
	
	public void addFilePath(String path) {
		this.getView().getPickers().addFilePath(new SelectFile(this, path));
		this.getView().pack();
	}

	public void removeFile(SelectFile file) {
		this.getView().getPickers().removeFile(file);
		this.getView().pack();
	}
	
}
