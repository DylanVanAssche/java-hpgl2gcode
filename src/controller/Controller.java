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

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import model.Configuration;
import model.GCodeWriter;
import model.HPGLReader;
import model.Job;

public class Controller {
	private static Controller controller;
	
	private Controller() {
		// Controller stuff
		// Configuration for each JOB: engraving, milling, drilling all different jobs!
		Configuration configuration = new Configuration(20000, 10.0, -0.165, 500, 300, 40.0, 3.0);
		Job job = new Job(configuration);	
		
		try {
			FileReader fileIn = new FileReader("/home/dylan/Projects/eclipse-workspace/java-hpgl2gcode/test/randomLEDController_Pen3.plt");
			HPGLReader reader = new HPGLReader(fileIn, job);
			reader.start();
			reader.join(); // wait until everything is read
			FileWriter fileOut = new FileWriter("/home/dylan/Projects/eclipse-workspace/java-hpgl2gcode/test/randomLEDController_engraving.gcode");
			GCodeWriter writer = new GCodeWriter(fileOut, job);
			writer.start();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	// Singleton pattern, only 1 instance may exist! Use .newInstance() to retrieve a Controller instance
	public static Controller newInstance() {
		if(controller == null) {
			controller = new Controller();
		}
		return controller;
	}
	
	// Launch the Controller on application start
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		Controller controller = Controller.newInstance();
	}
	
}
