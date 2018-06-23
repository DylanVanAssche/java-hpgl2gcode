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

package model.commands;

import model.Configuration;

public class ToolInit extends Command {
	private Configuration configuration;
	
	public ToolInit(String HPGLGcode) {
		super(HPGLGcode);
	}
	
	public ToolInit(String HPGLGcode, Configuration configuration) {
		super(HPGLGcode);
		this.setConfiguration(configuration);
	}

	@Override
	public String getGCodeString() throws IllegalStateException {
		// http://linuxcnc.org/docs/html/gcode/g-code.html#gcode:g20-g21
		// http://linuxcnc.org/docs/html/gcode/g-code.html#gcode:g90-g91
		// http://linuxcnc.org/docs/html/gcode/g-code.html#gcode:g4
		// http://linuxcnc.org/docs/html/gcode/m-code.html#mcode:m3-m4-m5
		if(this.getConfiguration().getSpindleSpeed() > 0) {
			String gcode = String.join(
					System.getProperty("line.separator"),
					"G21", // millimetres
					"G90", // absolute coordinates
					"M3 S" + this.getConfiguration().getSpindleSpeed(), // Turn the spindle on and set the speed
				    "G4 P" + this.getConfiguration().getSpindlePowerUpTime() // Wait for the spindle to power up
					);
			return gcode;
		}
		else {
			throw new IllegalStateException("Spindle speed must be > 0");
		}
	}

	public Configuration getConfiguration() {
		return configuration;
	}

	public void setConfiguration(Configuration configuration) {
		this.configuration = configuration;
	}
	
	@Override
	public String toString() {
		return "ToolInit(" + this.getId() + ")";
	}

}
