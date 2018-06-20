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

package model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class HPGLReader extends Thread {
	private BufferedReader input;
	private ArrayList<String> commandList = new ArrayList<String>();
	
	public HPGLReader(FileReader input) {
		this.input = new BufferedReader(input);
	}
	
	public void run() {
		Exception error;
		while(true) {
			try {
				String line = this.input.readLine();
				if(line != null) {
					this.commandList.add(line);
				}
				else {
					break;
				}
			} catch (IOException e) {
				error = e;
				e.printStackTrace();
				break;
			}
		}
		
		System.out.println(this.commandList);
	}
}
