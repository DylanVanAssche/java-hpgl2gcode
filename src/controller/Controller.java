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

import model.CommandFactory;
import model.Configuration;
import model.HPGLReader;
import view.MainView;

public class Controller {
	private static Controller controller;
	
	private Controller() {
		// Controller stuff
		/*FileReader file;
		try {
			file = new FileReader("/home/dylan/Projects/eclipse-workspace/java-hpgl2gcode/test/randomLEDController_Pen3.plt");
			HPGLReader reader = new HPGLReader(file);
			reader.start();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		// Configuration for each JOB: engraving, milling, drilling all different jobs!
		Configuration configuration = new Configuration(20000, 10.0, -0.165, 500, 300, 40.0, 3.0); // USER BASED config via GUI
		System.out.println(CommandFactory.newInstance().parseHPGLCode("IN;", configuration).getGCodeString());
		System.out.println(CommandFactory.newInstance().parseHPGLCode("SP1;", configuration).getGCodeString());
		System.out.println(CommandFactory.newInstance().parseHPGLCode("PU;", configuration).getGCodeString());
		System.out.println(CommandFactory.newInstance().parseHPGLCode("PT0;", configuration).getGCodeString());
		System.out.println(CommandFactory.newInstance().parseHPGLCode("PA25,464;", configuration).getGCodeString());
		System.out.println(CommandFactory.newInstance().parseHPGLCode("PA25", configuration).getGCodeString());
		//System.out.println(CommandFactory.newInstance().parseHPGLCode("PA25;", configuration).getGCodeString());
		MainView view = new MainView(this);
	}
	
	// Singleton pattern, only 1 instance may exist! Use .newInstance() to retrieve a Controller instance
	public static Controller newInstance() {
		if(controller == null) {
			controller = new Controller();
		}
		return controller;
	}
	
	// Launch the Controller on application start
	public static void main(String[] args) {
		Controller controller = Controller.newInstance();
	}
	
}
